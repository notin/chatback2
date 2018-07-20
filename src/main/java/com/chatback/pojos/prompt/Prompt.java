package com.chatback.pojos.prompt;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Prompt {

	@JsonProperty("instruction")
	private String instruction;

	@JsonProperty("output")
	private List<String> leadin;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("userInteraction")
	private String userInteraction;

	public void setInstruction(String instruction){
		this.instruction = instruction;
	}

	public String getInstruction(){
		return instruction;
	}

	public void setOutput(List<String> leadin){
		this.leadin = leadin;
	}

	public List<String> getLeadin(){
		return leadin;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserInteraction(String userInteraction){
		this.userInteraction = userInteraction;
	}

	public String getUserInteraction(){
		return userInteraction;
	}

	@Override
 	public String toString(){
		return 
			"Prompt{" +
			"instruction = '" + instruction + '\'' + 
			",leadin = '" + leadin + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",userInteraction = '" + userInteraction + '\'' + 
			"}";
		}
}