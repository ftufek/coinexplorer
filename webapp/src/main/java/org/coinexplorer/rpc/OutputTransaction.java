package org.coinexplorer.rpc;

public class OutputTransaction {
	private double value;
	private int n; // Output Transaction #
	private ScriptPublicKey scriptPubKey;
	
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public ScriptPublicKey getScriptPubKey() {
		return scriptPubKey;
	}
	public void setScriptPubKey(ScriptPublicKey scriptPubKey) {
		this.scriptPubKey = scriptPubKey;
	}
	
	
	
}
