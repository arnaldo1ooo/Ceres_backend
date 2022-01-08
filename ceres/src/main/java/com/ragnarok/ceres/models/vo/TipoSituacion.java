package com.ragnarok.ceres.models.vo;

import java.util.HashMap;
import java.util.Map;

public enum TipoSituacion {
	Activa("A"), Inactiva("I"), Evaluando("O"), Iniciado("D"), Bloqueado("B");

	private static TipoSituacion[] allValues = values();

	public static TipoSituacion fromOrdinal(int n) {
		return allValues[n];
	}

	private String value;

	private TipoSituacion(String value)
    {
        this.setValue(value);
    }

	public String getValue() {
		return value;
	}

	public static TipoSituacion getTipo(String value) {
		switch (value) {
		case "A":
			return TipoSituacion.Activa;
		case "I":
			return TipoSituacion.Inactiva;
		case "O":
			return TipoSituacion.Evaluando;
		case "D":
			return TipoSituacion.Iniciado;
		case "B":
			return TipoSituacion.Bloqueado;
		}
		return null;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static Map<String, TipoSituacion> listarSituaciones() {
		Map<String, TipoSituacion> situacoes;
		situacoes = new HashMap<>();
		situacoes.put(TipoSituacion.Activa.toString(), TipoSituacion.Activa);
		situacoes.put(TipoSituacion.Bloqueado.toString(), TipoSituacion.Bloqueado);
		situacoes.put(TipoSituacion.Evaluando.toString(), TipoSituacion.Evaluando);
		situacoes.put(TipoSituacion.Inactiva.toString(), TipoSituacion.Inactiva);
		situacoes.put(TipoSituacion.Iniciado.toString(), TipoSituacion.Iniciado);
		return situacoes;
	}
}
