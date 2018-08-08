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

	@JsonProperty("t")
	private String t;

	@JsonProperty("f")
	private String f;

	@JsonProperty("contents")
	private int contents;

	@JsonProperty("time")
	private int time;
}