package org.coinexplorer.rpc;

public class BlockHash {
	private int index;
	private String hash;
	
	public BlockHash(String hash){
		this.hash = hash;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index){
		this.index = index;
	}
	
	public String getHash() {
		return hash;
	}
}
