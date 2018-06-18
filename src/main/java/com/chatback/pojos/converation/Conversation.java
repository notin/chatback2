package com.chatback.pojos.converation;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
public class Conversation{

	@JsonProperty("responses")
	private List<Response> responses;

	@JsonProperty("messages")
	private List<Message> messages;

	@JsonProperty("startTime")
	private int startTime;

	@JsonProperty("id")
	private int id;

	@JsonProperty("endTime")
	private int endTime;

	@Override
 	public String toString(){
		return 
			"Conversation{" + 
			"responses = '" + responses + '\'' + 
			",messages = '" + messages + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",id = '" + id + '\'' + 
			",endTime = '" + endTime + '\'' + 
			"}";
		}
}