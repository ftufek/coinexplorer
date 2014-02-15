package org.coinexplorer.rpc;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.coinexplorer.config.RPCConfig;

import com.google.common.collect.ImmutableList;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;


public class BTCRPC {
	private JsonRpcHttpClient client;
	private RPCConfig cfg;
	
	public BTCRPC(RPCConfig cfg) {
		this.cfg = cfg;
		try{
			client = new JsonRpcHttpClient(new URL(cfg.getUrl()),
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
			return client.invoke("getblock", 
								  ImmutableList.of(hash), 
								  Block.class);
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Block getblock(int index){
		return getblock(getblockhash(index).getHash());
	}
	
	public RawTransaction getrawtransaction(String txid){
		try{
			return client.invoke("getrawtransaction", 
								  ImmutableList.of(txid, 1),
								  RawTransaction.class);
		}catch(Throwable e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Will return all the raw transactions that are in the blocks that
	 * are in the range. The range is inclusive, for example if block_start_range = 2
	 * and block_end_range = 4 then the transactions in the blocks 2,3 and 4 are
	 * going to be returned.
	 * 
	 * @param block_start_range
	 * @param block_end_range
	 * @return a list containing all the transactions
	 */
	public List<RawTransaction> getRawTransactionsForBlocks(int block_start_range, int block_end_range){
		if(block_end_range < block_start_range){ return new ArrayList<>(); }
		ExecutorService threads = Executors.newFixedThreadPool(cfg.getNumberThreads());
		final List<Block> blocks = new ArrayList<Block>();
		for(int i = block_start_range; i <= block_end_range; i++){
			blocks.add(getblock(i));
		}
		final List<RawTransaction> txs = Collections.synchronizedList(new ArrayList<RawTransaction>());
		for(Block b : blocks){
			for(final String tx : b.getTx()){
				threads.execute(new Runnable() {
					@Override
					public void run() {
						synchronized (txs) {
							txs.add(getrawtransaction(tx));
						}
					}
				});
			}
		}
		threads.shutdown();
		try {
			threads.awaitTermination(100, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return txs;
	}
}