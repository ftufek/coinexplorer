package org.coinexplorer;

import org.coinexplorer.config.CEConfig;
import org.junit.Test;

public class ConfigTest {
	@Test
	public void test() throws Exception {
		CEConfig cfg = new CEConfig(CEConfig.Type.TEST);
	}

}
