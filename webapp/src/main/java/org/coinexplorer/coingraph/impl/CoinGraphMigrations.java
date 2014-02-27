package org.coinexplorer.coingraph.impl;

import org.coinexplorer.graph.nodes.NLabel;
import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.StringLogger;

public class CoinGraphMigrations {
	private GraphDatabaseService graphDb;
	
	public CoinGraphMigrations(GraphDatabaseService graphDb){
		this.graphDb = graphDb;
	}
	
	public void run(){
		ExecutionEngine engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);
		try(Transaction tx = graphDb.beginTx()){
			//Put unique constraint on address property
			engine.execute("CREATE CONSTRAINT ON (a:Address) ASSERT a.address IS UNIQUE");
			
			//Create coinbase node which has the address 0
			ExecutionResult coinbaseRes = engine.execute("MATCH (a:Address {address:\"0\"}) RETURN a");
			if(coinbaseRes.size() == 0){
				Node coinbaseNode = graphDb.createNode();
				coinbaseNode.addLabel(NLabel.Address);
				coinbaseNode.setProperty("address", "0");
			}else{
				coinbaseRes.close();
			}
			tx.success();
		}
	}
}
