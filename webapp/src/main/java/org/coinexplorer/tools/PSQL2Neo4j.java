package org.coinexplorer.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.coinexplorer.coingraph.CoinGraph;
import org.coinexplorer.coingraph.impl.CoinGraphImpl;
import org.coinexplorer.coingraph.nodes.NTransaction;
import org.coinexplorer.coingraph.relations.RInputTransaction;
import org.coinexplorer.config.CEConfig;

public class PSQL2Neo4j {
	private CoinGraph coinGraph;
	private Connection connection;
	
	public PSQL2Neo4j(CoinGraph coinGraph){
		this.coinGraph = coinGraph;
		
		init();
	}
	
	public void init(){
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
		}
		connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql:abe", "user","");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
	}
	
	public void mergeCoinbase() throws SQLException{
		int start_from = coinGraph.getContinuationTxId();
		
		// make sure autocommit is off
		connection.setAutoCommit(false);
		Statement st = connection.createStatement();
		
		// Turn use of the cursor on.
		st.setFetchSize(100000);
		ResultSet rs = st.executeQuery(
				"SELECT tx.tx_id AS tx_id, tx.tx_hash AS tx_hash, itx.tx_hash AS txin_hash, "
				+ "txout.txout_pos AS out_number, txout.txout_value AS amount "
				+ "FROM tx "
				+ "LEFT JOIN txin ON txin.tx_id = tx.tx_id "
				+ "LEFT JOIN txout ON txout.txout_id = txin.txout_id "
				+ "LEFT JOIN tx AS itx ON itx.tx_id = txout.tx_id "
				+ "WHERE tx.tx_id > " + start_from + " ORDER BY tx.tx_id LIMIT 1000000");
		List<NTransaction> nTxs = new ArrayList<>();
		int max_id = 0;
		while(rs.next()){
			max_id = rs.getInt("tx_id");
			if(rs.getString("txin_hash") == null || rs.getString("txin_hash").equals("NULL")){
				//coinbase tx
				nTxs.add(new NTransaction(rs.getString("tx_hash"), new ArrayList<RInputTransaction>()));
			}else{
				NTransaction itx = new NTransaction(rs.getString("txin_hash"), new ArrayList<RInputTransaction>());
				RInputTransaction ritx = new RInputTransaction(itx, rs.getInt("out_number"), rs.getDouble("amount"));
				List<RInputTransaction> ixs = new ArrayList<>();
				ixs.add(ritx);
				nTxs.add(new NTransaction(rs.getString("tx_hash"), ixs));
			}
			if(nTxs.size() >= 10000){
				//flush to neo4j
				System.out.println("Flushing to neo4j at "+rs.getInt("tx_id"));
				coinGraph.insertTransactions(nTxs);
				coinGraph.setContinuationTxId(rs.getInt("tx_id"));
				nTxs.clear();
			}
		}
		if(nTxs.size() > 0){
			coinGraph.insertTransactions(nTxs);
			coinGraph.setContinuationTxId(max_id);
			nTxs.clear();
		}
		rs.close();
		st.close();
	}
	
	public static void main(String[] args) throws SQLException{
		CoinGraph graph = new CoinGraphImpl(new CEConfig());
		PSQL2Neo4j psql2neo4j = new PSQL2Neo4j(graph);
		psql2neo4j.mergeCoinbase();
	}
}
