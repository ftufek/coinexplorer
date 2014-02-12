package org.coinexplorer.config;

public class RPCConfig {
	private String user;
	private String password;
	private String url;
	private Type type;
	
	public RPCConfig(String user, String password, String url, Type type) {
		super();
		this.user = user;
		this.password = password;
		this.url = url;
		this.type = type;
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

	public enum Type{
		Bitcoin
	}
}
