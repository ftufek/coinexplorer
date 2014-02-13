package org.coinexplorer.graph.nodes;

import java.util.HashMap;
import java.util.Map;

import org.coinexplorer.graph.GraphBatchInsert.BatchCapsule;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;

public class NAddress implements NBase<NAddress> {
	private final String PROPERTY_NAME = "address";
	private String address;
	
	public NAddress(String address) {
		super();
		this.address = address;
	}
	
	@Override
	public Node toNeoNode(Node node) {
		node.addLabel(NLabel.Address);
		node.setProperty(PROPERTY_NAME, address);
		return node;
	}

	@Override
	public NAddress fromNeoNode(Node node, Class<NAddress> clazz) {
		return null;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	private Label getLabel(){
		return NLabel.Address;
	}
	
	private Map<String,Object> getProperty(){
		Map<String,Object> property = new HashMap<>();
		property.put("address",address);
		return property;
	}

	@Override
	public BatchCapsule getBatchCapsule() {
		return new BatchCapsule(getLabel(),getProperty(),PROPERTY_NAME);
	}


}
