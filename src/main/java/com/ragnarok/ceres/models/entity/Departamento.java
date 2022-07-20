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
	@JsonProperty("_id") //Debe ser el mismo nombre que el del modelo del front
	@Column(name="dep_id")
	private Long id;

	@JsonProperty("nombre")
	@Column(name="dep_nombre", length=50, nullable=false)
	private String nombre;

	@JsonProperty("sucursal")
	@ManyToOne	//Muchos Departamentos para una Sucursal
	@JoinColumn(name="dep_sucursal", nullable=false)
	private Sucursal sucursal;

	@JsonProperty("situacion")
	@Column(name="dep_situacion", length=1, nullable=false)
	private String situacion;
	
}
