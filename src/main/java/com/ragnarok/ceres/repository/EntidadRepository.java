package com.ragnarok.ceres.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ragnarok.ceres.models.entity.Entidad;

@Repository
public interface EntidadRepository extends JpaRepository<Entidad, Long> {
	
	
	
}