package org.coinexplorer.graph;

import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.kernel.impl.util.StringLogger;

/**
 * The migrations work by keeping track of the DB version.
 * The graph includes a node called Config which has the
 * version property.
 * 
 * @author FT
 *
 */
public class GraphMigrations {
	private GraphDatabaseService graphDb;
	
	public GraphMigrations(GraphDatabaseService graphDb){
		this.graphDb = graphDb;
	}
	
	public void run(){
		ExecutionEngine engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);
		try(Transaction tx = graphDb.beginTx()){
			engine.execute("CREATE CONSTRAINT ON (a:Address) ASSERT a.address IS UNIQUE");
			tx.success();
		}
	}
}
