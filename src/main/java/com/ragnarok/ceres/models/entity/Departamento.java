package com.ragnarok.ceres.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ragnarok.ceres.models.vo.TipoSituacion;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departamento")
@Getter
@Setter
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("_id") //Cuando se convierte Objeto a Json transforma el nombre a _id
	@Column(name="dep_id")
	private Long id;
	
	@Column(name="dep_nombre", length=45, nullable=false)
	private String nombre;
	
	@ManyToOne	//Muchos Departamentos para una Sucursal
	@JoinColumn(name="dep_sucursal", nullable=false)
	private Sucursal sucursal;
	
	@Column(name="dep_situacion", length=1, nullable=false)
	private String situacion;
	
}
