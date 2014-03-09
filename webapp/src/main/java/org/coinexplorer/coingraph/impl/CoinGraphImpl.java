package org.coinexplorer.coingraph.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.coinexplorer.coingraph.CoinGraph;
import org.coinexplorer.coingraph.nodes.NLabel;
import org.coinexplorer.coingraph.nodes.NTransaction;
import org.coinexplorer.coingraph.relations.RInputTransaction;
import org.coinexplorer.coingraph.relations.RLabel;
import org.coinexplorer.config.CEConfig;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.UniqueFactory;
import org.neo4j.kernel.impl.util.StringLogger;

@ApplicationScoped
public class CoinGraphImpl implements CoinGraph {
	@Inject
	CEConfig config;
	
	private GraphDatabaseService graphDb;
	
	public CoinGraphImpl(){}
	
	public CoinGraphImpl(CEConfig config){
		this.config = config;
		
		init();
	}
	
	@PostConstruct
	public void init(){
		this.graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(config.getGraphDbPath());
		new CoinGraphMigrations(graphDb).run();
	}
	
	@PreDestroy
	public void destroy(){
		graphDb.shutdown();
	}

	@Override
	public void insertTransactions(List<NTransaction> txNodes) {
		try(Transaction tx = graphDb.beginTx()){
			UniqueFactory.UniqueNodeFactory factory = new UniqueFactory.UniqueNodeFactory(graphDb, "hash") {
				@Override
				protected void initialize(Node created, Map<String, Object> properties) {
					created.addLabel(NLabel.Transaction);
					created.setProperty("hash", properties.get("hash"));
				}
			};
			for(NTransaction txNode : txNodes){
				Node n = factory.getOrCreate("hash", txNode.getTxHash());
				if(txNode.getInputTxs().size() > 0){
					for(RInputTransaction itx : txNode.getInputTxs()){
						Node in = factory.getOrCreate("hash", itx.getInputTx().getTxHash());
						Relationship relation = in.createRelationshipTo(n, RLabel.Spent);
						relation.setProperty("vout", itx.getVout());
						relation.setProperty("amount", itx.getAmount());
					}
				}
			}
			tx.success();
		}
	}

	@Override
	public int getContinuationTxId() {
		int tx_id = 0;
		ExecutionEngine engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterator<Node> result = engine.execute("MATCH (cfg:Config{id:0}) RETURN cfg;").columnAs("cfg");
			while(result.hasNext()){
				Node n = result.next();
				int temp_tx_id = Integer.valueOf(n.getProperty("max_tx_id", "0").toString());
				if(temp_tx_id > tx_id){
					tx_id = temp_tx_id;
				}
			}
			tx.success();
		}
		return tx_id;
	}

	@Override
	public void setContinuationTxId(int tx_id) {
		ExecutionEngine engine = new ExecutionEngine(graphDb);
		try(Transaction tx = graphDb.beginTx()){
			engine.execute("MERGE (cfg:Config{id:0})");
			engine.execute("MATCH (cfg:Config{id:0}) SET cfg.max_tx_id="+tx_id);
			tx.success();
		}
	}
}
