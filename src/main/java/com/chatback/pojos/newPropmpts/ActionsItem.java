package com.chatback.pojos.newPropmpts;

import com.chatback.pojos.match.IGuid;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@Entity
@ToString
public class ActionsItem
{

	@Id
//	@JsonProperty("id")
	@Column(name = "id", updatable = false, nullable = false)
	private String id= IGuid.getGUIS();

	@JsonProperty("v")
	private String v;

	@JsonProperty("k")
	private String k;
}