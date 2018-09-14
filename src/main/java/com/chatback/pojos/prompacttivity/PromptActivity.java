package com.chatback.pojos.prompacttivity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.chatback.GuiGenerator.getGUIS;
import static com.chatback.utils.JsonConverter.toJson;

@Data
@Builder
@Entity
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PromptActivity
{

	@JsonProperty("meta-info")
	private String metaInfo;

	@JsonProperty("time")
	private String time;

	@JsonProperty("prompt")
	private String prompt;

	@Id
	private String id = getGUIS();

	@Override
	public String toString()
	{
		return toJson(this);
	}
}