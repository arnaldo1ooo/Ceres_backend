package com.ragnarok.ceres.controller.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {
	
	@NotEmpty
	private String email;
	@NotEmpty
	private String pass;
	
	
	
	
	public Authentication convertir() {
		return new UsernamePasswordAuthenticationToken(email, pass);
	}
	
}
