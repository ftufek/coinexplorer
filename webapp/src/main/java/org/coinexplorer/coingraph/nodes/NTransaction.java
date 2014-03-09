package org.coinexplorer.coingraph.nodes;

import java.util.List;

import org.coinexplorer.coingraph.relations.RInputTransaction;


public class NTransaction {
	private String txHash;
	private List<RInputTransaction> inputTxs;
	
	public NTransaction(String txHash, List<RInputTransaction> inputTxs) {
		this.txHash = txHash;
		this.inputTxs = inputTxs;
	}

	public String getTxHash() {
		return txHash;
	}
	
	public List<RInputTransaction> getInputTxs(){
		return inputTxs;
	}
}
