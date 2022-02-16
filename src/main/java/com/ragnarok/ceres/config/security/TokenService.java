package com.ragnarok.ceres.config.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.ragnarok.ceres.models.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${ceres.jwt.expirationTime}")	//Obtiene el valor de application.properties
	private Long expirationTime;
	
	@Value("${ceres.jwt.secret}")			//Obtiene el valor de application.properties
	private String secret;
	
	@Value("${ceres.jwt.issuer}")			//Obtiene el valor de application.properties
	private String issuer;
	
	public String generarToken(Authentication authentication) {
		Usuario usuario = (Usuario) authentication.getPrincipal();
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDateTime fechaExpiracion = fechaActual.plusMinutes(expirationTime);
		
		return Jwts.builder()
				.setIssuer(issuer)
				.setSubject(usuario.getId().toString())
				.setIssuedAt(Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant()))
				.setExpiration(Date.from(fechaExpiracion.atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public Optional<Jws<Claims>> getTokenInfo(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token);
			
			System.out.println("Token aceptado");
			
			return Optional.of(claims);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Token rechazado");
			return Optional.empty();
		} 
	}
	
	
}