package com.chatback.pojos.newPropmpts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;

@Data
@Builder
@Entity
public class Pompts2{

	@JsonProperty("response")
	private Response response;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("key")
	private String key;
}