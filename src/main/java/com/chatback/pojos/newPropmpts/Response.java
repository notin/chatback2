package com.chatback.pojos.newPropmpts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("main")
	private Main main;

	@JsonProperty("actions")
	private List<ActionsItem> actions;

	@JsonProperty("key")
	private String key;
}