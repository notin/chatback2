package com.chatback.pojos.prompt;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Builder
public class Prompts {

	@JsonProperty("prompt")
	private Prompt[] prompt;

}