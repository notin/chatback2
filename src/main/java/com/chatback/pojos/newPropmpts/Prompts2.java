package com.chatback.pojos.newPropmpts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@Builder
@Entity
@ToString
public class Prompts2
{

	@Id
	@JsonProperty("id")
	private String id;


	@ManyToOne
	@JsonProperty("response")
	private ResponsePrompt response;

	@ManyToOne
	@JsonProperty("main")
	private Main main;

	@JsonProperty("k")
	private int k;
}