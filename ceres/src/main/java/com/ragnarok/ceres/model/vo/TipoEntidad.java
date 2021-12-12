package com.ragnarok.ceres.model.vo;

import java.util.HashMap;
import java.util.Map;

public enum TipoEntidad {
    
	Física("F"), Juridica("J");
	
	private static TipoEntidad[] allValues = values();
	
	public static TipoEntidad fromOrdinal(int n){
        return allValues[n];
    }

    private String value;
    
    private TipoEntidad(String value){
        this.setValue(value);
    }

    public String getValue(){
        return value;
    }

    public static TipoEntidad getTipoEntidade(String value){
        if (value == null || value.equals("F"))
        {
            return TipoEntidad.Física;
        }
        else
        {
            return TipoEntidad.Juridica;
        }
    }

    public void setValue(String value){
        this.value = value;
    }

    public static Map<String, TipoEntidad> listarTipos(){
        Map<String, TipoEntidad> tipos = new HashMap<>();
        tipos.put("Fisica", TipoEntidad.Física);
        tipos.put("Juridica", TipoEntidad.Juridica);
        return tipos;
    } 
}
