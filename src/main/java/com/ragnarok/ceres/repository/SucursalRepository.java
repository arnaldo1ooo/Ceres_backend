package com.ragnarok.ceres.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ragnarok.ceres.models.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long> {
	
	Optional<Sucursal> findByNombre(String nombreSucursal);
	
}