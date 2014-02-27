package org.coinexplorer.config;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CEConfig {
	private static final String CONFIG_FOLDER = System.getProperty("user.home")+"/.coinexplorer/";
	
	@PostConstruct
	public void init(){
		initConfigFolder();
	}
	
	public String getGraphDbPath(){
		return CONFIG_FOLDER+"/neo4j.db";
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
