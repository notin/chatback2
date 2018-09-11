package com.chatback.pojos.newPropmpts;

import java.util.List;

import com.chatback.pojos.match.IGuid;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.Id;

@Data
@Builder
@Entity
@ToString
public class ResponsePrompt implements com.chatback.pojos.newPropmpts.Id
{

	@Id
//	@JsonProperty("id")
	@Column(name = "id", updatable = false, nullable = false)
	private String id= IGuid.getGUIS();

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