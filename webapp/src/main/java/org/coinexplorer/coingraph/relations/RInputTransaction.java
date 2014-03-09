package org.coinexplorer.coingraph.relations;

import org.coinexplorer.coingraph.nodes.NTransaction;

public class RInputTransaction {
	private NTransaction inputTx;
	private int vout;
	private double amount;
	
	public RInputTransaction(NTransaction inputTx, int vout, double amount) {
		this.inputTx = inputTx;
		this.vout = vout;
		this.amount = amount;
	}
	
	public NTransaction getInputTx() {
		return inputTx;
	}
	
	public int getVout() {
		return vout;
	}
	
	public double getAmount() {
		return amount;
	}
}
