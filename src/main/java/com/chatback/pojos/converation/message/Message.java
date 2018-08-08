package com.chatback.pojos.converation.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message
{

	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("text")
	private String gender;

	@JsonProperty("from")
	private String preferedGenderOfPartner;

	@JsonProperty("to")
	private int age;
}