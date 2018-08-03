package com.chatback.pojos.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Builder
@Data
public class DBConnection{

	@JsonProperty("isConnected")
	private boolean isConnected;

	public void setIsConnected(boolean isConnected){
		this.isConnected = isConnected;
	}

	public boolean isIsConnected(){
		return isConnected;
	}

	@Override
 	public String toString(){
		return 
			"DBConnection{" + 
			"isConnected = '" + isConnected + '\'' + 
			"}";
		}
}