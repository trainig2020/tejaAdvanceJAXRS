package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {

	public static void main(String[] args) {
		InvocationDemo demo=new InvocationDemo();
		Invocation invocation=demo.PrepareReqForMsgforYear(2015);
		Response response=invocation.invoke();
		System.out.println(response.getStatus());

	}

	private  Invocation PrepareReqForMsgforYear(int year) {
		Client client = ClientBuilder.newClient();
	return	client. target("http://localhost:8081/AdvancedJaxRs_Client/webapi/")
                   .path("message").queryParam("year", year).request(MediaType.APPLICATION_JSON).
                   buildGet();
		
		
	}

}
