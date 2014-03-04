package org.coinexplorer.rest;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Path("/address")
@Api(value="/address", description="Functions related to coin addresses.")
@Produces(MediaType.APPLICATION_JSON)
public interface Address {
	@GET
	@Path("/{address}")
	@ApiOperation(value="Get information about the given address.")
	public Map<String, Object> index(
			@ApiParam(value="Public address") @PathParam("address") String address);
}
