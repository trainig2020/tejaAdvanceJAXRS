package com.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.Message;

public class RestApiClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
	WebTarget baseTarget=	client. target("http://localhost:8081/AdvancedJaxRs_Client/webapi/");
	WebTarget messagesTarget=baseTarget.path("message");
	WebTarget singleMessageTarget=messagesTarget.path("{messageId}");
		Message message = singleMessageTarget.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON).get(Message.class);
		Message message2 = singleMessageTarget.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON).get(Message.class);
		
		//post
		Message newMessage=new Message(4,"My new msg from JAXRSclient","tejaa");
	Response postResponse=	messagesTarget.request().post(Entity.json(newMessage));
	if(postResponse.getStatus()!=201) {
		System.out.println("Error");
	}
	
		
		//Message message = resp.readEntity(Message.class);
		//System.out.println(message.getAuthor());
		//System.out.println(message2.getAuthor());
	Message createMessage=postResponse.readEntity(Message.class);
	System.out.println(createMessage.getMessage());
	}

}
