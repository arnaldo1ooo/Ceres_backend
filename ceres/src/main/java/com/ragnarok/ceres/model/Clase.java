package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "clase")
@Getter
@Setter
public class Clase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cla_id")
	private Long id;
	
	@Column(name="cla_nombre")
	private String nombre;
	
}