package org.coinexplorer.rpc;

import java.util.List;

public class Block {
	private String hash;
	private int confirmations;
	private int size;
	private int height;
	private int version;
	private String merkleroot;
	private List<String> tx; //list of transaction ids in the block
	private double time;
	private double nonce;
	private String bits;
	private double difficulty;
	private String previousblockhash;
	private String nextblockhash;
	private String chainwork;
	
	public String getHash() {
		return hash;
	}
	public int getConfirmations() {
		return confirmations;
	}
	public int getSize() {
		return size;
	}
	public int getHeight() {
		return height;
	}
	public int getVersion() {
		return version;
	}
	public String getMerkleroot() {
		return merkleroot;
	}
	public List<String> getTx() {
		return tx;
	}
	public double getTime() {
		return time;
	}
	public double getNonce() {
		return nonce;
	}
	public String getBits() {
		return bits;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public String getPreviousblockhash() {
		return previousblockhash;
	}
	public String getNextblockhash() {
		return nextblockhash;
	}
	public String getChainwork() {
		return chainwork;
	}
	
}
