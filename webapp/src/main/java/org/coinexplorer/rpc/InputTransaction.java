package org.coinexplorer.rpc;

public class InputTransaction {
	
	private String txid;   //Input transaction id #
	private int vout;      //Input transaction output #
	private ScriptSignature scriptSig;
	private int sequence; //0xFFFFFFFF oh yeah ?
	private String coinbase;
	
	private boolean isCb = false;

	
	public boolean isCoinbase() {
		return isCb;
	}
	
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public int getVout() {
		return vout;
	}
	public void setVout(int vout) {
		this.vout = vout;
	}
	public ScriptSignature getScriptSig() {
		return scriptSig;
	}
	public void setScriptSig(ScriptSignature scriptSig) {
		this.scriptSig = scriptSig;
	}
	public long getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getCoinbase() {
		return coinbase;
	}
	public void setCoinbase(String coinbase) {
		this.coinbase = coinbase;
		this.isCb = true;
	}
	
}
