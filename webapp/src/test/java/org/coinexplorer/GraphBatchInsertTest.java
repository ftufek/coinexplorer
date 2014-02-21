package org.coinexplorer;

import java.util.ArrayList;
import java.util.List;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.graph.GraphBatchInsert;
import org.coinexplorer.graph.SQLConnection;
import org.coinexplorer.graph.nodes.NAddress;
import org.coinexplorer.rpc.BTCRPC;
import org.coinexplorer.rpc.Block;
import org.coinexplorer.rpc.RawTransaction;
import org.junit.Before;
import org.junit.Test;

public class GraphBatchInsertTest {
	private final String DEBUG_TAG = "[GraphBatchInsertTest]: ";
	private BTCRPC rpc;
	
	@Before
	public void setUp(){
//		batchInsert = new GraphBatchInsert<NAddress>(new CEConfig(CEConfig.Type.TEST).getGraphConfig());
		rpc = new BTCRPC(new CEConfig(CEConfig.Type.TEST).getBtcRpcConfig());
	}
	
	
//	public void basic(){
//		long time = System.currentTimeMillis();
//		
//		List<Block> blocks = new ArrayList<>();
//		for(int i = 200000; i<200100; i++){
//			blocks.add(rpc.getblock(i));
//		}
//		
//		System.out.println(DEBUG_TAG+" Scrapped all blocks.");
//		int blockCount = 0;
//		List<String> outAddresses = new ArrayList<>();
//		
//		for(Block b : blocks){
//			time = System.currentTimeMillis();
//			int outAddrSize = outAddresses.size();
//			for(String sTx : b.getTx()) {
//				
//				RawTransaction tx = rpc.getrawtransaction(sTx);
//				List<String> addrs = tx.getOutAdresses();
//				
//				for(String addr : addrs){
//					if(!outAddresses.contains(addr)){
//						outAddresses.add(addr);
//					}
//				}
//			}
//			if( blockCount % 100 == 0){
//				
//				System.out.println(DEBUG_TAG +"Pushed " + (outAddresses.size() - outAddrSize) + " Addresses of block " + blockCount +" .");
//				System.out.println(DEBUG_TAG +"In " + toSeconds(System.currentTimeMillis() - time) + "seconds. "); 
//			}
//			blockCount++;
//		}	
//		
//		System.out.println(DEBUG_TAG + "outAddresses.size(): " + outAddresses.size() + ".");
//		
//		for(String out : outAddresses){
//			batchInsert.addToBatchList(new NAddress(out));
//		}
//		
//		time = System.currentTimeMillis();
//		
//		batchInsert.batchInsert();
//		
//		System.out.println(DEBUG_TAG + "Time to push the nodes to DB: " + toSeconds(System.currentTimeMillis() - time)+ " seconds.");
//	}
	
	@Test
	public void populateDB(){
		SQLConnection sql = new SQLConnection();
		
		GraphBatchInsert<NAddress> batchInsert;
		
		for(int i = 1; i < 4700000; i+= 100000) {
			
			
			ArrayList<String> outAddresses = sql.GetAddressesFrom(i, i + 100000);
			
			System.out.println(DEBUG_TAG + "Fetched SQL addresses from " + i +" to " + (i + 100000) +" .");
			
			batchInsert = new GraphBatchInsert<NAddress>(new CEConfig(CEConfig.Type.TEST).getGraphConfig());
			
			for(String out : outAddresses){
				batchInsert.addToBatchList(new NAddress(out));
			}
			
			long time = System.currentTimeMillis();
			
			batchInsert.batchInsert();
			
			System.out.println(DEBUG_TAG + "Time to push the nodes to DB: " + toSeconds(System.currentTimeMillis() - time) + " seconds.");
			System.out.println();
		}
	}	
	static float toSeconds(long time)
	{
		return (float) ( (double) time / (double) 1000);
	}
}