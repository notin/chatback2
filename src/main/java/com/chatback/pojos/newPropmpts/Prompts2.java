package com.chatback.pojos.newPropmpts;

import com.chatback.pojos.match.IGuid;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Id;


@Data
@Builder
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Prompts2
{

	@Id
//	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private String id = IGuid.getGUIS();

	@ManyToOne
	@JsonProperty("response")
	private ResponsePrompt response;

	@ManyToOne
	@JsonProperty("main")
	private Main main;

	@JsonProperty("k")
	private int k;
}