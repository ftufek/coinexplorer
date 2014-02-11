package org.coinexplorer.config;

import java.io.File;
import java.io.IOException;

public class CEConfig {
	private static final String CONFIG_FILE = System.getProperty("user.home")+"/.coinexplorer/config.db";
	
	/**
	 * As of now, the configType doesn't affect the behavior
	 * of the class. But in the future, the functions are
	 * supposed to return different kinds of information depending
	 * on the configType.
	 * 
	 * @param configType
	 */
	public CEConfig(Type configType){
	}
	
	public RPCConfig getBtcRpcConnection(){
		return new RPCConfig("bitcoinrpc", 
							 "9GYLQ12RfgBqoc8uKXhBjMqqb63dR39J8MzivigkvA2K", 
							 null, null, null, null);
	}
	
	public String getNeo4jServer(){
		return "http://localhost:7474/db/data";
	}
	
	/**
	 * Will create the config file if it doesn't exist.
	 * @throws IOException if it fails to create the config file
	 */
	private void initConfigFile() throws Exception{
		File cfgFile = new File(CONFIG_FILE);
		if(!cfgFile.exists()){
			File folder = cfgFile.getParentFile();
			if(!folder.exists() && !folder.mkdirs()){
				throw new IllegalStateException("Couldn't create dir: " + folder);
			}
			cfgFile.createNewFile();
		}
	}
	
	public static enum Type{
		TEST
	}
}
