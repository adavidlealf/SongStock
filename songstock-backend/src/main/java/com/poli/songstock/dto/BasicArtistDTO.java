package com.poli.songstock.dto;

import java.util.Objects;

public class BasicArtistDTO {

	/**
	 * Name of the item
	 */
	private String name;


	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		return Objects.equals(name, other.name);
	}

	/**
	 * Empty Constructor
	 */
	public BasicArtistDTO() {
	}

	/**
	 * @param nombre
	 */
	public BasicArtistDTO(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
