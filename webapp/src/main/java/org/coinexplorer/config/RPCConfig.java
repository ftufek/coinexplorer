package org.coinexplorer.config;

import javax.persistence.Entity;


public class RPCConfig {
	private String user;
	private String password;
	private String protocol;
	private String host;
	private String port;
	private Type type;
	
	public RPCConfig(String user, String password, String protocol,
			String host, String port, Type type) {
		super();
		this.user = user;
		this.password = password;
		this.protocol = protocol;
		this.host = host;
		this.port = port;
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
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
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
