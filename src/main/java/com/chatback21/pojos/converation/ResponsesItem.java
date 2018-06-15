package com.chatback21.pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResponsesItem{

	@JsonProperty("user_b")
	private String userB;

	@JsonProperty("user_a")
	private String userA;

	@JsonProperty("type")
	private String type;

	public void setUserB(String userB){
		this.userB = userB;
	}

	public String getUserB(){
		return userB;
	}

	public void setUserA(String userA){
		this.userA = userA;
	}

	public String getUserA(){
		return userA;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"ResponsesItem{" + 
			"user_b = '" + userB + '\'' + 
			",user_a = '" + userA + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}