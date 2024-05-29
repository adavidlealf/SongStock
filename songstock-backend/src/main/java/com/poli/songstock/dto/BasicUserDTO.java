package com.poli.songstock.dto;

import java.util.Objects;

public class BasicUserDTO {
	
	private Long id;
	
	/**
	 * Nickname of the item
	 */
	private String nickname;

	/**
	 * Name of the item
	 */
	private String name;

	/**
	 * @param id
	 * @param nickname
	 * @param name
	 */
	public BasicUserDTO(Long id, String nickname, String name) {
		this.id = id;
		this.nickname = nickname;
		this.name = name;
	}

	/**
	 * 
	 */
	public BasicUserDTO() {
		// TODO Auto-generated constructor stub
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
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, nickname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicUserDTO other = (BasicUserDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(nickname, other.nickname);
	}

}
