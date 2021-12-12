package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

public class Localidad {
	@Entity
	@Table(name = "localidad")
	@Getter
	@Setter
	public class Municipio {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "loc_id")
		private Long id;
		
	    @Column(name = "loc_nombre")
		private String nombre;
		
	    @Column(name = "loc_municipio")
		private Municipio municipio;
		
	}

}
