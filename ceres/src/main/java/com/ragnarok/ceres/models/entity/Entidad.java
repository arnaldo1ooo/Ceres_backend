package com.ragnarok.ceres.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ragnarok.ceres.models.vo.TipoEntidad;
import com.ragnarok.ceres.models.vo.TipoSituacion;

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

	@ManyToOne	//Muchas Entidades para una Sucursal
    @JoinColumn(name = "ent_sucursal")
	private Sucursal sucursal;
    
    @Column(name = "ent_nombre")
	private String nombre;
	
    @Column(name = "ent_apellido")
	private String apellido;
	
    @ManyToOne	//Muchas Entidades para un Municipio
    @JoinColumn(name = "ent_municipio")
	private Municipio municipio;
    
    @ManyToOne	//Muchas Entidades para una Localidad
    @JoinColumn(name = "ent_barrio")
	private Barrio barrio;
	
    @Column(name = "ent_direccion")
	private String direccion;
	
    @Column(name = "ent_situacion")
	private TipoSituacion situacion;
	
    @Column(name = "ent_tipo")
	private TipoEntidad tipo;
	
    @Column(name = "ent_ruc")
	private String ruc;
		
    @Column(name = "ent_email")
	private String email;
    
    @Column(name = "ent_obs")
	private String observacion;
    
    @Column(name = "ent_fechacreacion")
	private Date fechacreacion;
}
