package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragnarok.ceres.models.entity.Departamento;
import com.ragnarok.ceres.models.entity.Sucursal;
import com.ragnarok.ceres.repository.DepartamentoRepository;
import com.ragnarok.ceres.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	private SucursalRepository sucursalRepository;
	
	
	
	@Override
	@Cacheable(value = "listadoSucursal")
	@Transactional(readOnly = true)	//Para indicar que es una transaccion de solo lectura
	public Iterable<Sucursal> findAll() {
		
		return sucursalRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Sucursal> findAll(Pageable pageable) {
		
		return sucursalRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Sucursal> findById(Long id) {
		
		return sucursalRepository.findById(id);
	}

	@Override
	@Transactional //Para indicar que hará cambios en la bd
	public Sucursal save(Sucursal sucursal) {
		
		return sucursalRepository.save(sucursal);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		
		sucursalRepository.deleteById(id);
	}
	
	
	
}
