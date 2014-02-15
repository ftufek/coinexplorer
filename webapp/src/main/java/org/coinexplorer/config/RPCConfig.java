package org.coinexplorer.config;

public class RPCConfig {
	private final static int DEFAULT_NUMBER_THREADS = 20;
	
	private String user;
	private String password;
	private String url;
	private Type type;
	
	private int numberThreads; // used to setup how many parallel threads
							  //are used to access the RPC
	
	public RPCConfig(String user, String password, String url, Type type) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
		this.type = type;
		this.numberThreads = DEFAULT_NUMBER_THREADS;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getNumberThreads() {
		return numberThreads;
	}

	public void setNumberThreads(int numberThreads) {
		this.numberThreads = numberThreads;
	}


	public enum Type{
		Bitcoin
	}
}
