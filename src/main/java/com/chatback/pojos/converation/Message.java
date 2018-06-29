package com.chatback.pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
public class Message {

	@JsonProperty("from")
	private String from;

	@JsonProperty("text")
	private String text;

	@JsonProperty("to")
	private String to;

	@JsonProperty("timestamp")
	private int timestamp;


	@Override
 	public String toString(){
		return 
			"Message{" +
			"from = '" + from + '\'' + 
			",text = '" + text + '\'' + 
			",to = '" + to + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}

}