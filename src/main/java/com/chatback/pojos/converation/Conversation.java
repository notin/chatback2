package com.chatback.pojos.converation;

import com.chatback.pojos.converation.message.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@ToString
public class Conversation
{
	@Id
	@JsonProperty("id")
	private String id;

	@JsonProperty("response")
	@OneToMany
	@JoinColumn(name = "response")
	private List<Response> response = new ArrayList<>();

	@JsonProperty("message")
	@OneToMany
	@JoinColumn(name = "id", referencedColumnName = "id")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Message> message = new ArrayList<>();

	@JsonProperty("startTime")
	private String startTime;

	@JsonProperty("endTime")
	private int endTime;


	@Override
	public String toString()
	{
		String self = "";
		ObjectMapper mapper = new ObjectMapper();

		try
		{
			self = mapper.writeValueAsString(this);
		}
		catch (Exception e)
		{

		}
		return self;
	}
}