package com.ragnarok.ceres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragnarok.ceres.config.security.AutenticacionService;
import com.ragnarok.ceres.controller.dto.TokenDTO;
import com.ragnarok.ceres.controller.form.LoginForm;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {
	@Autowired
	private AutenticacionService autenticacionService;
	
	
	@PostMapping
	public ResponseEntity<?> auth(@RequestBody @Valid LoginForm loginForm){
		try {
			String token = autenticacionService.autenticarConToken(loginForm);
			
			//System.out.println("El token generado (valido por Xm) " + token);
			
			return ResponseEntity.ok(new TokenDTO(token, "Bearer "));	//Si existe el usuario y pass ingresado devuelve status 200 con el token
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();	//Si no existe devuelve status 400
		}
		
	}
}
