package com.poli.songstock.dto;

import java.util.Objects;

public class BasicArtistDTO {
	
	private Long id;

	/**
	 * Name of the item
	 */
	private String name;

	/**
	 * @param id
	 * @param name
	 */
	public BasicArtistDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	

	/**
	 * 
	 */
	public BasicArtistDTO() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, name);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
