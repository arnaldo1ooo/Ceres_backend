package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ragnarok.ceres.models.entity.Departamento;
import com.ragnarok.ceres.models.entity.Sucursal;

public interface SucursalService {
	
	public Iterable<Sucursal> findAll(); 
	
	public Page<Sucursal> findAll(Pageable pageable);
	
	public Optional<Sucursal> findById(Long id); 
	
	public Sucursal save(Sucursal sucursal);
	
	public void deleteById(Long id);
	
	
}
