package com.ragnarok.ceres.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@Column(name="cla_nombre", length=45)
	private String nombre;
	
    @ManyToMany (mappedBy = "clases")
    List<Entidad> entidades;
	
}