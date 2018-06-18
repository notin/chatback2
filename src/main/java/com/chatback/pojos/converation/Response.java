package com.chatback.pojos.converation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
public class Response {

	@JsonProperty("type")
	private String type;

	@JsonProperty("gui_2")
	private String gui2;

	@JsonProperty("gui_1")
	private String gui1;

	@Override
 	public String toString(){
		return 
			"Response{" +
			"type = '" + type + '\'' + 
			",gui_2 = '" + gui2 + '\'' + 
			",gui_1 = '" + gui1 + '\'' + 
			"}";
		}
}