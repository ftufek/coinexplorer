package org.coinexplorer.graph;


import java.util.List;

import org.coinexplorer.config.GraphConfig;
import org.coinexplorer.graph.nodes.NBase;
import org.coinexplorer.graph.nodes.NLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


public class Graph {
	private GraphDatabaseService graphDb;
	
	public Graph(GraphConfig graphConfig){
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(graphConfig.getDbPath());
		registerShutdownHook(graphDb);
		new GraphMigrations(graphDb).run();
	}
	
	public <T> void addNode(NBase<T> toInsert){
		try(Transaction tx = graphDb.beginTx()){
			toInsert.toNeoNode(graphDb.createNode());
			tx.success();
		}
	}
	
	public boolean isAddressPresent(String address){
		boolean exists = false;
		try(Transaction tx = graphDb.beginTx()){
			Iterable<Node> nodes = graphDb.findNodesByLabelAndProperty(NLabel.Address, "address", address);
			for(Node _ : nodes){
				exists = true;
			}
		}
		return exists;
	}
	
	public <T> void batchInsert(List<NBase<T>> nodes){
	}
	
	private void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    // Registers a shutdown hook for the Neo4j instance so that it
	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	    // running application).
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	            graphDb.shutdown();
	        }
	    } );
	}
}
