package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragnarok.ceres.models.entity.Departamento;
import com.ragnarok.ceres.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	
	
	@Override
	@Cacheable(value = "listadoDepartamento")
	@Transactional(readOnly = true)	//Para indicar que es una transaccion de solo lectura
	public Iterable<Departamento> findAll() {
		
		return departamentoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Departamento> findAll(Pageable pageable) {
		
		return departamentoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Departamento> findById(Long id) {
		
		return departamentoRepository.findById(id);
	}

	@Override
	@Transactional //Para indicar que hará cambios en la bd
	public Departamento save(Departamento departamento) {
		
		return departamentoRepository.save(departamento);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		departamentoRepository.deleteById(id);
	}
	
	
	
}
