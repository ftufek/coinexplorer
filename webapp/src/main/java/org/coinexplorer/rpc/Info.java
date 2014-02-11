package org.coinexplorer.rpc;

public class Info {
	private int version;
	private int protocolversion;
	private int walletversion;
	private double balance;
	private int blocks;
	private int timeoffset;
	private int connections;
	private String proxy;
	private double difficulty;
	private boolean testnet;
	private double keypoololdest;
	private int keypoolsize;
	private double paytxfee;
	private double unlockeduntil;
	private String errors;

	public int getVersion() {
		return version;
	}

	public int getProtocolversion() {
		return protocolversion;
	}

	public int getWalletversion() {
		return walletversion;
	}

	public double getBalance() {
		return balance;
	}

	public int getBlocks() {
		return blocks;
	}

	public int getTimeoffset() {
		return timeoffset;
	}

	public int getConnections() {
		return connections;
	}

	public String getProxy() {
		return proxy;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public boolean isTestnet() {
		return testnet;
	}

	public double getKeypoololdest() {
		return keypoololdest;
	}

	public int getKeypoolsize() {
		return keypoolsize;
	}

	public double getPaytxfee() {
		return paytxfee;
	}

	public double getUnlockeduntil() {
		return unlockeduntil;
	}

	public String getErrors() {
		return errors;
	}
}
