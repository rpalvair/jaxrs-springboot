package com.palvair.jaxrs.springboot;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class RestWsResponse {

	private String body;
	
	public RestWsResponse(String body) {
		this.body = body;
	}
	
	public RestWsResponse() {
		
	}
}
