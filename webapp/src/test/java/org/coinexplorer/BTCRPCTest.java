package org.coinexplorer;
import static org.junit.Assert.*;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.config.RPCConfig;
import org.coinexplorer.rpc.BTCRPC;
import org.coinexplorer.rpc.Info;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BTCRPCTest {
	BTCRPC rpc;
	
	@Before
	public void setUp() throws Exception {
		rpc = new BTCRPC(new CEConfig(CEConfig.Type.TEST).getBtcRpcConnection());
		if(!rpc.isConnected()){
			throw new Exception("Test RPC client wasn't able to connect!");
		}
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void getinfo(){
		Info info = rpc.getinfo();
		assertTrue(info.getConnections() > 0);
	}
	
	@Test
	public void getblockhash(){
		assertEquals("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f",
					 rpc.getblockhash(0).getHash());
		assertEquals("00000000c937983704a73af28acdec37b049d214adbda81d7e2a3dd146f6ed09",
					 rpc.getblockhash(1000).getHash());
		assertEquals("0000000099c744455f58e6c6e98b671e1bf7f37346bfd4cf5d0274ad8ee660cb",
					 rpc.getblockhash(10000).getHash());
	}
	
	@Test
	public void getblock(){
		//Get Genesis block
		assertEquals("4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b",
					 rpc.getblock("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f")
						.getMerkleroot());
	}
	
	@Test
	public void getrawtransaction(){
		System.out.println(rpc.getrawtransaction("6048c5fbeae0ac6327df6df390f96ef6c74c80b537a7bb6427b6151f72787bbb"));
	}
}
