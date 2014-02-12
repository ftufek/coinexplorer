package org.coinexplorer;
import static org.junit.Assert.*;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.config.RPCConfig;
import org.coinexplorer.rpc.BTCRPC;
import org.coinexplorer.rpc.Block;
import org.coinexplorer.rpc.Info;
import org.coinexplorer.rpc.RawTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BTCRPCTest {
	BTCRPC rpc;
	
	@Before
	public void setUp() throws Exception {
		rpc = new BTCRPC(new CEConfig(CEConfig.Type.TEST).getBtcRpcConfig());
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
		String tx = "6d5777e765a46779573528e8e78b7e9f8b8de304dfab3606e177ee8a0406d90b";
		assertEquals(83.43324691,rpc.getrawtransaction(tx).getVout().get(0).getValue(),	0.0000000000001);
	}
	
	@Test
	public void getCoinbase() {
		String coinbaseTx = "408db832204f1b3c0740184c071bfc7b61d772462bea6e11fec478eef38a4ec1";
		assertTrue(rpc.getrawtransaction(coinbaseTx).isCoinbase());
		
		//Check that the first transaction of the block is the Coinbase transaction
		Block anyBlock = rpc.getblock(rpc.getblockhash(10000).getHash());
		RawTransaction cbTx = rpc.getrawtransaction(anyBlock.getTx().get(0));
		assertTrue(cbTx.isCoinbase());
	}
}
