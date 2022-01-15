package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ragnarok.ceres.models.entity.Entidad;

public interface EntidadService {
	
	public Iterable<Entidad> findAll(); 
	
	public Page<Entidad> findAll(Pageable pageable);
	
	public Optional<Entidad> findById(Long id); 
	
	public Entidad save(Entidad entidad);
	
	public void deleteById(Long id);
	
	
}
