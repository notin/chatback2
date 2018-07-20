package com.chatback.pojos.prompt;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Prompts{

	@JsonProperty("prompt")
	private List<Prompt> prompt;

	public void setPrompt(List<Prompt> prompt){
		this.prompt = prompt;
	}

	public List<Prompt> getPrompt(){
		return prompt;
	}

	@Override
 	public String toString(){
		return 
			"Prompts{" + 
			"prompt = '" + prompt + '\'' + 
			"}";
		}
}