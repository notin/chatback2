package com.chatback.pojos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@ToString
public class User
{

	@Id
	@JsonProperty("id")
	private String id;

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
}