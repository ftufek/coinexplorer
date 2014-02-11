package org.coinexplorer;

import org.coinexplorer.config.CEConfig;
import org.coinexplorer.graph.Graph;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private Graph graph;
	
	@Before
	public void setUp(){
		graph = new Graph(new CEConfig(CEConfig.Type.TEST).getGraphConfig());
	}
	
	@Test
	public void basic(){
		
	}
}
