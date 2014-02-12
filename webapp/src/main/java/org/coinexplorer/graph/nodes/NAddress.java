package org.coinexplorer.graph.nodes;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.schema.Schema;


public class NAddress implements NBase {
	public String address;

	public NAddress(String address) {
		super();
		this.address = address;
	}
	
	@Override
	public Node fillNode(Node node) {
		node.addLabel(NLabel.Address);
		node.setProperty("address", address);
		return node;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
