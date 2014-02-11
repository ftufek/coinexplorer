package org.coinexplorer.rpc;

public class RawTransaction {
	private String hex;
	private String txid;
	private int version;
	private int locktime;
	
	@Override
	public String toString() {
		return "RawTransaction [hex=" + hex + "]";
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String getTxid() {
		return txid;
	}

	public void setTxid(String txid) {
		this.txid = txid;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getLocktime() {
		return locktime;
	}

	public void setLocktime(int locktime) {
		this.locktime = locktime;
	}
	
	
}
