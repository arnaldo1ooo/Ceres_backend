package com.ragnarok.ceres.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TokenDTO {

	private String token;
	private String type;

	public TokenDTO(String token, String type) {
		this.token = token;
		this.type = type;
	}
	
}
