package org.coinexplorer.graph.nodes;

import java.util.List;

public class NTransaction {
	private List<String> outAddresses;
	
	public NTransaction(List<String> outAddresses) {
		super();
		this.outAddresses = outAddresses;
	}

	public List<String> getOutAddresses() {
		return outAddresses;
	}

	public void setOutAddresses(List<String> outAddresses) {
		this.outAddresses = outAddresses;
	}	
}
