package com.poli.songstock.dto;

import java.util.Objects;

public class BasicUserDTO {
	
	private String nickname;
	
	private String name;

	@Override
	public int hashCode() {
		return Objects.hash(name, nickname);
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
		return Objects.equals(name, other.name) && Objects.equals(nickname, other.nickname);
	}

	/**
	 * 
	 */
	public BasicUserDTO() {
		super();
	}

	/**
	 * @param nickname
	 * @param name
	 */
	public BasicUserDTO(String nickname, String name) {
		super();
		this.nickname = nickname;
		this.name = name;
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
	
	
	
}
