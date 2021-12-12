package com.ragnarok.ceres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ragnarok.ceres.model.vo.TipoSituacion;
import com.ragnarok.ceres.model.vo.TipoUsuario;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
	private Long id;
	
    @Column(name = "usu_nombre")
	private String nombre;
	
    @Column(name = "usu_apellido")
	private String apellido;
	
    @Column(name = "usu_administrador")
	private String administrador;
	
    @Column(name = "usu_login")
	private String login;
	
    @Column(name = "usu_pass")
	private String pass;
	
    @Column(name = "usu_entidad")
	private Entidad entidad;
	
    @Column(name = "usu_situacion")
	private TipoSituacion situacion;
	
    @Column(name = "usu_email")
	private String email;
	
    @Column(name = "usu_tipo")
	private TipoUsuario tipo;
	
    @Column(name = "usu_sucursal")
	private Sucursal sucursal;
	
    @Column(name = "usu_departamento")
	private Departamento departamento;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
