package com.chatback21.pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Message{

	@JsonProperty("name")
	private String name;

	@JsonProperty("text")
	private String text;

	@JsonProperty("timestamp")
	private int timestamp;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"Message{" + 
			"name = '" + name + '\'' + 
			",text = '" + text + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}