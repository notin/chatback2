package com.chatback.pojos.SysInfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;

@Data
@Builder
public class SysInfo{

	@JsonProperty("ip")
	private String ip;

	public void setIp(String ip){
		this.ip = ip;
	}

	public String getIp(){
		return ip;
	}

	@Override
 	public String toString(){
		return 
			"SysInfo{" + 
			"ip = '" + ip + '\'' + 
			"}";
		}
}