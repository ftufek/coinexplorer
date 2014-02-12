package org.coinexplorer.graph;

import java.util.Iterator;

import javax.ws.rs.NotFoundException;

import org.neo4j.cypher.ExecutionEngine;
import org.neo4j.cypher.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.helpers.collection.IteratorUtil;
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
		int version = 0;
		
		ExecutionEngine engine = new ExecutionEngine(graphDb, StringLogger.SYSTEM);
		ExecutionResult result;
		try(Transaction tx = graphDb.beginTx()){
			result = engine.execute("MATCH (config:CEConfig) RETURN config;");
			tx.success();
		}
		if(result.size() > 1){
			throw new Error("ERROR: there should be only 1 config Node!");
		}else if(result.size() == 1){
			Iterator<Node> config_col = (Iterator<Node>) result.columnAs("config");
			for(Node config : IteratorUtil.asIterable(config_col)){
				try{
					version = (int) config.getProperty("version");
				}catch(NotFoundException e){
				}
			}
		}
	}
}
