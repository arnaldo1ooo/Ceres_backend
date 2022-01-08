package com.ragnarok.ceres.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "entidad_clase")
@Getter
@Setter
public class EntidadClase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clen_id")
	private Long id;
		
    @Column(name = "clen_entidad")
	private Long entidad;
    
    @Column(name = "clen_iclase")
	private Long clase;
	
}
