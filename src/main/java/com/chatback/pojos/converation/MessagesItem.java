package com.chatback.pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MessagesItem{

	@JsonProperty("message")
	private Message message;

	public void setMessage(Message message){
		this.message = message;
	}

	public Message getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"MessagesItem{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}