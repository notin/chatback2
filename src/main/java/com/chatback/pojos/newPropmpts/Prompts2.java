package com.chatback.pojos.newPropmpts;

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
public class Prompts2
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

	@JsonProperty("k")
	private int k;
}