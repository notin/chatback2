package com.chatback.pojos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
public class User{

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("preferedGenderOfPartner")
	private String preferedGenderOfPartner;

	@JsonProperty("age")
	private int age;

	@JsonProperty("username")
	private String username;

	@JsonProperty("uid")
	private String uid;

	@Override
 	public String toString(){
		return 
			"User{" + 
			"gender = '" + gender + '\'' + 
			",preferedGenderOfPartner = '" + preferedGenderOfPartner + '\'' + 
			",age = '" + age + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}