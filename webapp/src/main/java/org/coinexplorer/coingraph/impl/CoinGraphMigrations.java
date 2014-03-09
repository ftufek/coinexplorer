package org.coinexplorer.coingraph.impl;

import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
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
			engine.execute("CREATE CONSTRAINT ON (tx:Transaction) ASSERT tx.hash IS UNIQUE;");
			engine.execute("CREATE CONSTRAINT ON (cfg:Config) ASSERT cfg.id IS UNIQUE;");
			tx.success();
		}
	}
}
