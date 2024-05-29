package com.poli.songstock.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Role {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Role.Name name;
	
	private String canSee;
	
	private String canModify;
	
	public enum Name {
		CONSUMER,
		DISTRIBUTOR,
		ADMINISTRATOR
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
	 * @return the canSee
	 */
	public String getCanSee() {
		return canSee;
	}

	/**
	 * @param canSee the canSee to set
	 */
	public void setCanSee(String canSee) {
		this.canSee = canSee;
	}

	/**
	 * @return the canModify
	 */
	public String getCanModify() {
		return canModify;
	}

	/**
	 * @param canModify the canModify to set
	 */
	public void setCanModify(String canModify) {
		this.canModify = canModify;
	}

	/**
	 * @return the name
	 */
	public Role.Name getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Role.Name name) {
		this.name = name;
	}
	
}