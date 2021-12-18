package com.ragnarok.ceres.model;

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
@Table(name = "localidad")
@Getter
@Setter
public class Localidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loc_id")
	private Long id;

	@Column(name = "loc_nombre")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY) //Muchas Localidades para un Municipio
	@JoinColumn(name = "loc_municipio")
	private Municipio municipio;

}
