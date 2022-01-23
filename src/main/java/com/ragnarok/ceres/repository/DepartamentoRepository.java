package com.ragnarok.ceres.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ragnarok.ceres.models.entity.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	Optional<Departamento> findByNombre(String nombreDepartamento);
	
}