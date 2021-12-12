package com.ragnarok.ceres.model.vo;

public enum TipoRuc {
	Comercial(1L), Servicio(2L), ComercialServicio(3L), Imagro(4L), ComercialImagro(5L), ServicioImagro(6L),
	ServicioComercialImagro(7L);

	private Long value;

	private TipoRuc(Long value) {
		this.setValue(value);
	}

	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}

	public static TipoRuc getTipoRuc(Long value) {
		switch (String.valueOf(value)) {
		case "1":
			return TipoRuc.Comercial;
		case "2":
			return TipoRuc.Servicio;
		case "3":
			return TipoRuc.ComercialServicio;
		case "4":
			return TipoRuc.Imagro;
		case "5":
			return TipoRuc.ComercialImagro;
		case "6":
			return TipoRuc.ServicioImagro;
		case "7":
			return TipoRuc.ServicioComercialImagro;
		}
		return null;
	}

	public boolean isComercial() {
		return this.equals(TipoRuc.Comercial) || this.equals(TipoRuc.ComercialServicio)
				|| this.equals(TipoRuc.ComercialImagro) || this.equals(TipoRuc.ServicioComercialImagro);
	}

	public boolean isServicio() {
		return this.equals(TipoRuc.Servicio) || this.equals(TipoRuc.ComercialServicio)
				|| this.equals(TipoRuc.ServicioImagro) || this.equals(TipoRuc.ServicioComercialImagro);
	}

	public boolean isImagro() {
		return this.equals(TipoRuc.Imagro) || this.equals(TipoRuc.ComercialImagro)
				|| this.equals(TipoRuc.ServicioImagro) || this.equals(TipoRuc.ServicioComercialImagro);
	}

	public static TipoRuc getTipoRuc(boolean isComercial, boolean isServico, boolean isImagro) {
		return getTipoRuc((isComercial ? TipoRuc.Comercial.getValue() : 0)
				+ (isServico ? TipoRuc.Servicio.getValue() : 0) + (isImagro ? TipoRuc.Imagro.getValue() : 0));
	}
}
