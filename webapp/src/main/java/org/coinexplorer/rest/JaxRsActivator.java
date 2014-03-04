package org.coinexplorer.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.coinexplorer.rest.impl.AddressImpl;

@ApplicationPath("/rest")
public class JaxRsActivator extends Application{

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<>();
		//Add REST classes
		resources.add(AddressImpl.class);
		
        resources.add(com.wordnik.swagger.jaxrs.JaxrsApiReader.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);        
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
        resources.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
		return resources;
	}
	
}
