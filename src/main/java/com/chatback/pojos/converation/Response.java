package com.chatback.pojos.converation;

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
public class Response
{
	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("gui_2")
	private String gui2;

	@JsonProperty("gui_1")
	private String gui1;

	@Override
 	public String toString(){
		return 
			"ResponsePrompt{" +
			"type = '" + type + '\'' + 
			",gui_2 = '" + gui2 + '\'' + 
			",gui_1 = '" + gui1 + '\'' + 
			"}";
		}
}