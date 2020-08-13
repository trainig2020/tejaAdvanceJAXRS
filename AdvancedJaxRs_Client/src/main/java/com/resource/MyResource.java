package com.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
public class MyResource {
	@PathParam("pathParam") private String pathParamEx;
	@QueryParam("query") private String queryParamEx;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		
		return "Test Run where PathParam is "+pathParamEx+" ; Query is  "+queryParamEx; 
	}

}
