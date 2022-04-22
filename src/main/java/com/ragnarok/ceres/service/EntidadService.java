package com.ragnarok.ceres.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ragnarok.ceres.exception.RecursoNoEncontradoException;
import com.ragnarok.ceres.models.entity.Entidad;
import com.ragnarok.ceres.repository.EntidadRepository;

@Service
public class EntidadService {

	@Autowired
	private EntidadRepository entidadRepository;

	@Cacheable(value = "listadoEntidad")
	@Transactional(readOnly = true)	//Para indicar que es una transaccion de solo lectura
	public Iterable<Entidad> buscarTodos() {
		return entidadRepository.findAll();
	};

	@Transactional(readOnly = true)
	public Page<Entidad> buscarTodos(Pageable pageable) {
		return entidadRepository.findAll(pageable);
	};

	@Transactional(readOnly = true)
	public Optional<Entidad> buscarPorId(Long id) {
		return entidadRepository.findById(id);
	};

	@Transactional //Para indicar que hará cambios en la bd
	public Entidad salvar(Entidad entidad) {
		return entidadRepository.save(entidad);
	};

	@Transactional
	public void eliminarPorId(Long id) {
		Optional<Entidad> oEntidad = entidadRepository.findById(id); // Se utiliza Optional para evitar error
		
		if (oEntidad.isPresent()) {
			entidadRepository.deleteById(id);
		} else {
			throw new RecursoNoEncontradoException(String.format("La entidad de id %s no fue encontrada", id));
		}
	};

}
