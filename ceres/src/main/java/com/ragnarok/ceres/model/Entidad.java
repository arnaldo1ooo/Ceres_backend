package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ragnarok.ceres.model.vo.TipoEntidad;
import com.ragnarok.ceres.model.vo.TipoSituacion;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "entidad")
@Getter
@Setter
public class Entidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ent_id")
	private Long id;

    @Column(name = "ent_sucursal")
	private Sucursal sucursal;
    
    @Column(name = "ent_nombre")
	private String nombre;
	
    @Column(name = "ent_apellido")
	private String apellido;
	
    @Column(name = "ent_localidad")
	private Localidad localidad;
	
    @Column(name = "ent_direccion")
	private String direccion;
	
    @Column(name = "ent_situacion")
	private TipoSituacion situacion;
	
    @Column(name = "ent_tipo")
	private TipoEntidad tipo;
	
    @Column(name = "ent_municipio")
	private Municipio municipio;
	
    @Column(name = "ent_ruc")
	private String ruc;
	
    @Column(name = "ent_tipoRuc")
	private String tipoRuc;
	
	
}
