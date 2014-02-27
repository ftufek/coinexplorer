package org.coinexplorer.graph;




public class Graph {
//	private GraphDatabaseService graphDb;
//	
//	public Graph(GraphConfig graphConfig){
//		this.graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(graphConfig.getDbPath());
//		registerShutdownHook(graphDb);
//		new GraphMigrations(graphDb).run();
//	}
//		
//	public <T> void addNode(NBase<T> toInsert){
//		try(Transaction tx = graphDb.beginTx()){
//			toInsert.toNeoNode(graphDb.createNode());
//			tx.success();
//		}
//	}
//	
//	public boolean isAddressPresent(String address){
//		boolean exists = false;
//		try(Transaction tx = graphDb.beginTx()){
//			Iterable<Node> nodes = graphDb.findNodesByLabelAndProperty(NLabel.Address, "address", address);
//			for(Node _ : nodes){
//				exists = true;
//			}
//		}
//		return exists;
//	}
//	
//	private void registerShutdownHook( final GraphDatabaseService graphDb )
//	{
//	    // Registers a shutdown hook for the Neo4j instance so that it
//	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
//	    // running application).
//	    Runtime.getRuntime().addShutdownHook( new Thread()
//	    {
//	        @Override
//	        public void run()
//	        {
//	            graphDb.shutdown();
//	        }
//	    } );
//	}
}
