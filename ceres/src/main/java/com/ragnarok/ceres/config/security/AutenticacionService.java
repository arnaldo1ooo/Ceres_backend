package com.ragnarok.ceres.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ragnarok.ceres.models.entity.Usuario;
import com.ragnarok.ceres.repository.UsuarioRepository;


@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByLogin(username);
        
        return usuario.orElseThrow(() -> new UsernameNotFoundException("Datos invalidos"));
        
    }
    
    
    public String convertirStringABCrypt(String pass) {
    	return new BCryptPasswordEncoder().encode(pass);
    }
    
}