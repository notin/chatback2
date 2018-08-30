package com.chatback.pojos.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

import static com.chatback.utils.JsonConverter.toJson;

@Data
@Builder
@Entity
@ToString
public class Activity
{

	@JsonProperty("meta-info")
	private String metaInfo;

	@JsonProperty("time")
	private String time;

	@JsonProperty("type")
	private String type;

	@Id
	@JsonProperty("id")
	private String id;

	@Override
	public String toString()
	{
		return toJson(this);
	}
}