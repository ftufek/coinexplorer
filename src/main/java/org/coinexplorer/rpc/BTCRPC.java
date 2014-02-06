package org.coinexplorer.rpc;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.coinexplorer.config.RPCConfig;

import com.google.common.collect.ImmutableList;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;


public class BTCRPC {
	private JsonRpcHttpClient client;
	
	public BTCRPC(RPCConfig cfg) {
		try{
			client = new JsonRpcHttpClient(new URL("http://142.157.164.243:8332/"),
											basicAuthenticationHeader(cfg.getUser(), 
																	  cfg.getPassword()));
		}catch(Exception e){
			client = null;
			e.printStackTrace();
		}
	}
	
	private Map<String, String> basicAuthenticationHeader(String username, 
														  String password){
		Map<String, String> header = new HashMap<>();
		header.put("Authorization", "Basic " + new String(
		Base64.encodeBase64((username+":"+password).getBytes())));
		return header;
	}
	
	public boolean isConnected(){
		return client != null;
	}
	
	public Info getinfo(){
		try{
			return client.invoke("getinfo", null, Info.class);
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}
	
	public BlockHash getblockhash(int index){
		try{
			BlockHash hash = client.invoke("getblockhash", 
											ImmutableList.of(index), 
											BlockHash.class);
			hash.setIndex(index);
			return hash;
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Block getblock(String hash){
		try{
			return client.invoke("getblock", ImmutableList.of(hash), Block.class);
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}
}