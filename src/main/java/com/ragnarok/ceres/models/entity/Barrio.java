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
@Table(name = "barrio")
@Getter
@Setter
public class Barrio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bar_id")
	private Long id;

	@Column(name = "bar_nombre")
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY) //Muchos Barrios para un Municipio
	@JoinColumn(name = "bar_municipio")
	private Municipio municipio;

}
