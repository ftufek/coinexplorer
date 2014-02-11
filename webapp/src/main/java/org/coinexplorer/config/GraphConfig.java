package org.coinexplorer.config;

public class GraphConfig {
	private String dbPath;

	public GraphConfig(String dbPath) {
		super();
		this.dbPath = dbPath;
	}

	public String getDbPath() {
		return dbPath;
	}

	public void setDbPath(String dbPath) {
		this.dbPath = dbPath;
	}
}
