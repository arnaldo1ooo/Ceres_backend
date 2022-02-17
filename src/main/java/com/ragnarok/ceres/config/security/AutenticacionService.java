package com.ragnarok.ceres.config.security;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ragnarok.ceres.controller.form.LoginForm;
import com.ragnarok.ceres.models.entity.Usuario;
import com.ragnarok.ceres.repository.UsuarioRepository;


@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
	@Lazy
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByNombreUsuario(username);
        
        return usuario.orElseThrow(() -> new UsernameNotFoundException("Datos invalidos"));
        
    }
    
    public String convertirStringABCrypt(String pass) {
    	return new BCryptPasswordEncoder().encode(pass);
    }
    
	public String autenticarConToken(@Valid LoginForm loginForm) {
		Authentication datosLogin = loginForm.convertir();	//Convierte el user pass a objeto authentication
		Authentication authentication = authManager.authenticate(datosLogin);	
		
		return tokenService.generarToken(authentication);	//Genera el token a partir del objeto authentication
	}
    
}