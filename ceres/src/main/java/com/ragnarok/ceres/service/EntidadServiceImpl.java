package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragnarok.ceres.models.entity.Entidad;
import com.ragnarok.ceres.repository.EntidadRepository;

@Service
public class EntidadServiceImpl implements EntidadService {

	@Autowired
	private EntidadRepository entidadRepository;
	
	
	
	@Override
	@Transactional(readOnly = true)	//Para indicar que es una transaccion de solo lectura
	public Iterable<Entidad> findAll() {
		
		return entidadRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Entidad> findAll(Pageable pageable) {
		
		return entidadRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Entidad> findById(Long id) {
		
		return entidadRepository.findById(id);
	}

	@Override
	@Transactional //Para indicar que hará cambios en la bd
	public Entidad save(Entidad entidad) {
		
		return entidadRepository.save(entidad);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		entidadRepository.deleteById(id);
	}
	
	
	
}
