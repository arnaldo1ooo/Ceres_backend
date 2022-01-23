package com.ragnarok.ceres.models.vo;


public enum TipoUsuario {
	
	Usuario("U"), Grupo("G"), Super("S"), System("Y");

	private String value;

	private TipoUsuario(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public static TipoUsuario getTipoRuc(String value) {
		switch (value) {
		case "U":
			return TipoUsuario.Usuario;
		case "G":
			return TipoUsuario.Grupo;
		case "S":
			return TipoUsuario.Super;
		case "Y":
			return TipoUsuario.System;
		}
		return null;
	}
}
