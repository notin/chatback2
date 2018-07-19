package com.chatback.pojos.prompt;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Prompt{

	@JsonProperty("prompt")
	private List<PromptItem> prompt;

	@Override
 	public String toString(){
		return 
			"Prompt{" + 
			"prompt = '" + prompt + '\'' + 
			"}";
		}
}