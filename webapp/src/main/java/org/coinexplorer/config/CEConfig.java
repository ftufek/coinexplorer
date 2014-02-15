package org.coinexplorer.config;

import java.io.File;
import java.io.IOException;

public class CEConfig {
	private static final String CONFIG_FOLDER = System.getProperty("user.home")+"/.coinexplorer/";
	
	/**
	 * As of now, the configType doesn't affect the behavior
	 * of the class. But in the future, the functions are
	 * supposed to return different kinds of information depending
	 * on the configType.
	 * 
	 * @param configType
	 */
	public CEConfig(Type configType){
		initConfigFolder();
	}
	
	public RPCConfig getBtcRpcConfig(){
		return new RPCConfig("bitcoinrpc",
							 "9GYLQ12RfgBqoc8uKXhBjMqqb63dR39J8MzivigkvA2K",
							 "http://132.206.31.69:8332/",
							 RPCConfig.Type.Bitcoin);
	}
	
	public GraphConfig getGraphConfig(){
		return new GraphConfig(CONFIG_FOLDER+"/neo4j.db");
	}
	
	/**
	 * Will create the config folder if it doesn't exist.
	 * @throws IOException if it fails to create the config file
	 */
	private void initConfigFolder(){
		File cfgFolder = new File(CONFIG_FOLDER);
		if(!cfgFolder.exists()){
			cfgFolder.mkdirs();
		}
	}
	
	public static enum Type{
		TEST
	}
}
