package com.chatback.pojos.newPropmpts;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.*;

@Data
@Builder
@Entity
@ToString
public class ResponsePrompt
{

	@Id
	@JsonProperty("id")
	private String id;

	@ManyToOne
	@JsonProperty("main")
	private Main main;

	@OneToMany
	@OrderColumn
	@JsonProperty("actions")
	private ActionsItem[] actions;

	@JsonProperty("k")
	private String k;
}