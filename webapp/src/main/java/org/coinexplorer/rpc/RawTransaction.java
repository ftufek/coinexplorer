package org.coinexplorer.rpc;

import java.util.List;

public class RawTransaction {
	private String hex;
	private String txid;
	private int version;
	private int locktime;
	private List<InputTransaction> vin;
	private List<OutputTransaction> vout;
	private String blockhash;
	private long confirmations;
	private long time;
	private long blocktime;
	
	@Override
	public String toString() {
		return "RawTransaction [hex=" + hex + ", txid=" + txid + ", version="
				+ version + ", locktime=" + locktime + ", vin=" + vin
				+ ", vout=" + vout + ", blockhash=" + blockhash
				+ ", confirmations=" + confirmations + ", time=" + time
				+ ", block=" + blocktime + "]";
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

	public List<InputTransaction> getVin() {
		return vin;
	}

	public void setVin(List<InputTransaction> vin) {
		this.vin = vin;
	}

	public List<OutputTransaction> getVout() {
		return vout;
	}

	public void setVout(List<OutputTransaction> vout) {
		this.vout = vout;
	}

	public String getBlockhash() {
		return blockhash;
	}

	public void setBlockhash(String blockhash) {
		this.blockhash = blockhash;
	}

	public long getConfirmations() {
		return confirmations;
	}

	public void setConfirmations(long confirmations) {
		this.confirmations = confirmations;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public long getBlocktime() {
		return blocktime;
	}

	public void setBlocktime(long blocktime) {
		this.blocktime = blocktime;
	}
}
