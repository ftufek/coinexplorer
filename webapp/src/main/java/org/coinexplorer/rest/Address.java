package org.coinexplorer.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.collect.ImmutableMap;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/address")
@Api(value="/address", description="a")
public class Address {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{address}/{ddd}")
	@ApiOperation(value="dd")
	public Map<String, Object> index(@ApiParam(value="a") @PathParam("address") String address){
		Map<String, Object> m = new HashMap<>();
		
		List<Map<String, String>> inputs = new ArrayList<>();
		inputs.add(ImmutableMap.of("input_address", "123456", "amount", "10"));
		inputs.add(ImmutableMap.of("input_address", "32123123", "amount", "100"));
		m.put("inputs", inputs);
		
		List<Map<String, String>> outputs = new ArrayList<>();
		outputs.add(ImmutableMap.of("output_address", "123456", "amount", "1"));
		outputs.add(ImmutableMap.of("output_address", "32123123", "amount", "10"));
		m.put("outputs", outputs);
		
		return m;
	}
}
