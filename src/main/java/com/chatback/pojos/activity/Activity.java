package com.chatback.pojos.activity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

import static com.chatback.utils.JsonConverter.toJson;

@Data
@SuperBuilder
@Entity
@ToString
public class Activity
{
	@JsonProperty("meta-info")
	protected String metaInfo;

	@JsonProperty("time")
	protected String time;

	@JsonProperty("type")
	protected String type;

	@Id
	@JsonProperty("id")
	protected String id;

	@Override
	public String toString()
	{
		return toJson(this);
	}
}