package com.chatback.pojos.converation;

import com.chatback.pojos.converation.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conversation
{
	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("message")
	@OneToMany
	@JoinColumn(name = "id")
	private List<Message> message;

	@JsonProperty("startTime")
	private String startTime;

	@JsonProperty("endTime")
	private int endTime;
}