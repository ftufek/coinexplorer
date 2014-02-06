package org.coinexplorer.config;

import java.io.File;
import java.io.IOException;

public class Config {
	private static final String CONFIG_FILE = System.getProperty("user.home")+"/.coinexplorer/config.db";
	
	public Config() throws Exception{
		initConfigFile();
	}
	
	/**
	 * Will create the config file if it doesn't exist.
	 * @throws IOException if it fails to create the config file
	 */
	public void initConfigFile() throws Exception{
		File cfgFile = new File(CONFIG_FILE);
		if(!cfgFile.exists()){
			File folder = cfgFile.getParentFile();
			if(!folder.exists() && !folder.mkdirs()){
				throw new IllegalStateException("Couldn't create dir: " + folder);
			}
			cfgFile.createNewFile();
		}
	}
}
