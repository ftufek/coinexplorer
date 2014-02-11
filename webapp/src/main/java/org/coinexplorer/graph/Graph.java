package org.coinexplorer.graph;

import org.coinexplorer.config.GraphConfig;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;


public class Graph {
	public GraphDatabaseService service;
	
	public Graph(GraphConfig graphConfig){
		service = new GraphDatabaseFactory().newEmbeddedDatabase(graphConfig.getDbPath());
		registerShutdownHook(service);
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
