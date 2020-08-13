package com.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.database.DatabaseClass;
import com.model.Message;


public class MessageService {
	private Map<Long, Message> messages = DatabaseClass.getMessage();
	
	public MessageService() {
		messages.put(1L, new Message(1, "Hello World", "teja"));
		messages.put(2L, new Message(2, "Hello India", "pooja"));
	}
	
	public List<Message> getAllMessage(){
		
		return new ArrayList<Message>(messages.values());	
		
	}
	
	public List<Message> getMessagesForYear(int year){
		List<Message> msgForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				msgForYear.add(message);
			}
		}
		return msgForYear;
	}
	
	public List<Message> getMessagePaginated(int start, int size){
		ArrayList<Message> lst = new ArrayList<Message>(messages.values());
		if(start+ size > lst.size()) return new ArrayList<Message>();
		return lst.subList(start, start+size);
	}
	
	public Message getMessages(long id) {
		Message message= messages.get(id);
		/*
		 * if(message==null) { throw new
		 * DataNotFoundException("Message with id : "+id+" Not Found"); }
		 */
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
