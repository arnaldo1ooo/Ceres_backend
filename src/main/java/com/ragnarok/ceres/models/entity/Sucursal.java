package com.ragnarok.ceres.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
    @Column(name = "suc_nombre", length=50, nullable=false)
	private String nombre;
	
    @ManyToOne //Muchas Sucursales para un Municipio
    @JoinColumn(name = "suc_municipio", nullable=false)
	private Municipio municipio;
    
    @ManyToOne //Muchas Sucursales para un Barrio
    @JoinColumn(name = "suc_barrio", nullable=false)
	private Barrio barrio;
	
}
