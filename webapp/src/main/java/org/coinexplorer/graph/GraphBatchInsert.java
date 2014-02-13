package org.coinexplorer.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.coinexplorer.config.GraphConfig;
import org.coinexplorer.graph.nodes.NBase;
import org.neo4j.graphdb.Label;
import org.neo4j.unsafe.batchinsert.BatchInserter;
import org.neo4j.unsafe.batchinsert.BatchInserters;

import scala.Array;
public class GraphBatchInsert<T> {
	
	BatchInserter batchDb;
	List<NBase<T>> nodeList;
	private boolean isDbOpened;
	
	public GraphBatchInsert(GraphConfig graphConfig) {
		nodeList = new ArrayList<NBase<T>>();
		batchDb = BatchInserters.inserter(graphConfig.getDbPath());
		if(batchDb != null) {
			isDbOpened = true;
			registerShutdownHook(batchDb);
		}
		else {
			isDbOpened = false;
		}
	}
	
	 /**
	 * 
	 * Proceeds with batch Insertion into the DB
	 * 
	 */
	public void batchInsert() {
		// Retrieve label from first element of list to call createDeffered...
		BatchCapsule firstCapsule = nodeList.get(0).getBatchCapsule();
		batchDb.createDeferredSchemaIndex(firstCapsule.getLabel())
											.on(firstCapsule.getPropertyName());
		
		for(NBase<T> node : nodeList) {
			BatchCapsule capsule = node.getBatchCapsule();
			batchDb.createNode(capsule.getProperty(),capsule.getLabel());
		}
		
		isDbOpened = false;
		batchDb.shutdown();
	}
	
	
	private void registerShutdownHook( final BatchInserter batchDb ) {
	    // Registers a shutdown hook for the Neo4j Batch inserter 
		// instance so that it shuts down nicely when the VM exits
		// (even if you "Ctrl-C" the running application).
		
	    Runtime.getRuntime().addShutdownHook( new Thread() {
	        @Override
	        public void run() {
	        	if(isDbOpened)
	        		batchDb.shutdown();
	        }
	    } );
	}
	
	public void addToBatchList(NBase<T> node){
		nodeList.add(node);
	}
	
	public static class BatchCapsule {
		Label label;
		HashMap<String,Object> property;
		String propertyName;
		
		public BatchCapsule(Label label, HashMap<String,Object> property,String propertyName){
			this.label = label;
			this.property = property;
			this.propertyName = propertyName;
		}
		
		public Label getLabel() {
			return label;
		}

		public HashMap<String, Object> getProperty() {
			return property;
		}
		
		public String getPropertyName() {
			return propertyName;
		}
		
	}
	
}
