package com.chatback.pojos.prompt;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Prompt {

	@JsonProperty("instruction")
	private String instruction;

	@JsonProperty("output")
	private String leadin;

	@Id
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

	public void setOutput(String leadin){
		this.leadin = leadin;
	}

	public String getLeadin(){
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

}