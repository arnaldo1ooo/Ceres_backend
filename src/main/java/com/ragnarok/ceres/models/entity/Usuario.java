package com.ragnarok.ceres.models.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ragnarok.ceres.models.vo.TipoSituacion;
import com.ragnarok.ceres.models.vo.TipoUsuario;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario implements UserDetails {
	
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
	
    @Column(name = "usu_login", unique = true)
	private String nombreUsuario;
	
    @Column(name = "usu_pass")
	private String contrasena;
	
    @OneToOne	//Un Usuario para una Entidad
    @JoinColumn(name = "usu_entidad")
	private Entidad entidad;
	
    @Column(name = "usu_situacion")
	private String situacion;
	
    @Column(name = "usu_email")
	private String email;
	
    @ManyToOne	//Muchos Usuarios para una Sucursal
    @JoinColumn(name = "usu_sucursal")
	private Sucursal sucursal;
	
    @ManyToOne	//Muchos Usuarios para un Departamento
    @JoinColumn(name = "usu_departamento")
	private Departamento departamento;
    
    @ManyToMany(fetch = FetchType.EAGER)//Para que traiga al consultar un usuario
    private List<Perfil> perfiles = new ArrayList<Perfil>();
	
	
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


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.contrasena;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.nombreUsuario;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
