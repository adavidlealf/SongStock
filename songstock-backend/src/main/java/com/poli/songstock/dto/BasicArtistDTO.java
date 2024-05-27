package com.poli.songstock.dto;

import java.util.Objects;

public class BasicArtistDTO {

	private String nombre;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicArtistDTO other = (BasicArtistDTO) obj;
		return Objects.equals(nombre, other.nombre);
	}

	/**
	 * 
	 */
	public BasicArtistDTO() {
		super();
	}

	/**
	 * @param nombre
	 */
	public BasicArtistDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
