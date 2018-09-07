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
public class ActionsItem
{

	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("v")
	private String v;

	@JsonProperty("k")
	private String k;
}