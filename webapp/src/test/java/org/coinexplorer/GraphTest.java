package org.coinexplorer;

import java.util.ArrayList;
import java.util.List;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.graph.Graph;
import org.coinexplorer.graph.nodes.NAddress;
import org.coinexplorer.rpc.BTCRPC;
import org.coinexplorer.rpc.Block;
import org.coinexplorer.rpc.RawTransaction;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph graph;
	private BTCRPC rpc;
	
	@Before
	public void setUp(){
		graph = new Graph(new CEConfig(CEConfig.Type.TEST).getGraphConfig());
		rpc = new BTCRPC(new CEConfig(CEConfig.Type.TEST).getBtcRpcConfig());
	}
	
	@Test
	public void basic(){
		List<Block> blocks = new ArrayList<>();
		blocks.add(rpc.getblock(100));
		blocks.add(rpc.getblock(1000));
		blocks.add(rpc.getblock(10000));
		
		List<String> outAddresses = new ArrayList<>();
		for(Block b : blocks){
			for(String sTx : b.getTx()){
				RawTransaction tx = rpc.getrawtransaction(sTx);
				outAddresses.addAll(tx.getOutAdresses());
			}
		}
		
		for(String out : outAddresses){
			if(!graph.isAddressPresent(out)){
				graph.addNode(new NAddress(out));
			}
		}
	}
}
