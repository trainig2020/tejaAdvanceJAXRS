package com.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.Message;

public class GenericDemo {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
			List<Message> message=client. target("http://localhost:8081/AdvancedJaxRs_Client/webapi/")
	                   .path("message").queryParam("year", 2020).request(MediaType.APPLICATION_JSON).
	                   get(new GenericType<List<Message>>() {});
			System.out.println(message);

	}

}
