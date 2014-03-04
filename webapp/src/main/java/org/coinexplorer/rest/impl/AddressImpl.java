package org.coinexplorer.rest.impl;

import java.util.HashMap;
import java.util.Map;

import org.coinexplorer.rest.Address;

public class AddressImpl implements Address{
	@Override
	public Map<String, Object> index(String address) {
		return new HashMap<String, Object>();
	}

}
