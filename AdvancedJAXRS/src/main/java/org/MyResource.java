package org;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test")
//@Singleton
public class MyResource {
	//private int count;
	@PathParam("pathParam")private String pathParamExample;
	@QueryParam("query")private String queryParamExample;
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod() {
		//count=count+1;
return "It works!! path and query param"+pathParamExample+queryParamExample;
}
}