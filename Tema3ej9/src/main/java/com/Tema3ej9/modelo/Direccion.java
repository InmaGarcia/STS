package com.Tema3ej9.modelo;

public class Direccion {

	private String calle;
	private String cp;
	private String ciudad;
	
	public Direccion(String calle, String cp, String ciudad) {
		super();
		this.calle = calle;
		this.cp = cp;
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
}
