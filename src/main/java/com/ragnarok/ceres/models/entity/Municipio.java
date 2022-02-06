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
@Table(name = "municipio")
@Getter
@Setter
public class Municipio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mun_id")
	private Long id;
	
    @Column(name = "mun_nombre", length=45, nullable=false)
	private String nombre;
	
}
