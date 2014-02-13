package org.coinexplorer;

import java.util.ArrayList;
import java.util.List;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.graph.GraphBatchInsert;
import org.coinexplorer.graph.nodes.NAddress;
import org.coinexplorer.graph.nodes.NBase;
import org.coinexplorer.rpc.BTCRPC;
import org.coinexplorer.rpc.Block;
import org.coinexplorer.rpc.RawTransaction;
import org.junit.Before;
import org.junit.Test;

public class GraphBatchInsertTest {
	private final String DEBUG_TAG = "[GraphBatchInsertTest]: ";
	private GraphBatchInsert<NAddress> batchInsert;
	private BTCRPC rpc;
	
	@Before
	public void setUp(){
		batchInsert = new GraphBatchInsert<NAddress>(new CEConfig(CEConfig.Type.TEST).getGraphConfig());
		rpc = new BTCRPC(new CEConfig(CEConfig.Type.TEST).getBtcRpcConfig());
	}
	
	@Test
	public void basic(){
		List<Block> blocks = new ArrayList<>();
		blocks.add(rpc.getblock(256000));
		
		List<String> outAddresses = new ArrayList<>();
		for(Block b : blocks){
			for(String sTx : b.getTx()) {
				RawTransaction tx = rpc.getrawtransaction(sTx);
				List<String> addrs = tx.getOutAdresses();
				
				for(String addr : addrs){
					if(!outAddresses.contains(addr)){
						outAddresses.add(addr);
					}
				}
			}
		}
		
		System.out.println(DEBUG_TAG + "outAddresses.size(): " + outAddresses.size() + ".");
		
		for(String out : outAddresses){
			batchInsert.addToBatchList(new NAddress(out));
		}
		
		batchInsert.batchInsert();
	}
}