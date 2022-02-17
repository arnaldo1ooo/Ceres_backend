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
	private String nombreUsuario;
	
	@NotEmpty
	private String contrasena;
	
	
	public Authentication convertir() {	//Convierte el (nombreUsuario recibido + contrasena recibido) en objeto Authentication
		return new UsernamePasswordAuthenticationToken(nombreUsuario, contrasena);
	}

}