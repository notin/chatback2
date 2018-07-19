package com.chatback.pojos.prompt;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PromptItem{

	@JsonProperty("instruction")
	private String instruction;

	@JsonProperty("leadin")
	private List<String> leadin;

	@JsonProperty("title")
	private String title;

	@Override
 	public String toString(){
		return 
			"PromptItem{" + 
			"instruction = '" + instruction + '\'' + 
			",leadin = '" + leadin + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}