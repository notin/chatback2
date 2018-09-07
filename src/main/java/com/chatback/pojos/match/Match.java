package com.chatback.pojos.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

import static com.chatback.utils.JsonConverter.toJson;

@Data
@Builder
@Entity
public class Match
{

	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("self")
	private String self;

	@JsonProperty("partner")
	private String partner;

	@JsonProperty("matched")
	private boolean matched;

	@JsonProperty("delivered")
	private boolean delivered;

	@JsonProperty("timestamp")
	private String timestamp;

	@JsonProperty("conversation")
	private String conversation;


	@Override
	public String toString()
	{
		return toJson(this);
	}
}