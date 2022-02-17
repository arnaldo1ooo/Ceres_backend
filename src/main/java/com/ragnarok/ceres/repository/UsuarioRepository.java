package com.ragnarok.ceres.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnarok.ceres.models.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByNombreUsuario(String username);
	
	
}