package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ragnarok.ceres.model.vo.TipoSituacion;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departamento")
@Getter
@Setter
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dep_id")
	private Long id;
	
	@Column(name="dep_nombre")
	private String nombre;
	
	@Column(name="dep_sucursal")
	private Sucursal sucursal;
	
	@Column(name="dep_situacion")
	private TipoSituacion tipoSituacion;
	
}
