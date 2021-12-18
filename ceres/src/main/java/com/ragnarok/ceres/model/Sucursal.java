package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sucursal")
@Getter
@Setter
public class Sucursal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suc_id")
	private Long id;
	
    @Column(name = "suc_descripcion")
	private String descripcion;
	
    @ManyToOne //Muchas Sucursales para un Municipio
    @JoinColumn(name = "suc_municipio")
	private Municipio municipio;
    
    @ManyToOne //Muchas Sucursales para una Localidad
    @JoinColumn(name = "suc_localidad")
	private Localidad localidad;
	
}
