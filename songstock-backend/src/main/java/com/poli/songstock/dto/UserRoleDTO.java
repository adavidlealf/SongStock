package com.poli.songstock.dto;

import com.poli.songstock.domain.Role;

public class UserRoleDTO {

	/**
	 * Instance of the user
	 */
	private UserDTO user;
	
	/**
	 * Fields that the user can see according to its role.
	 */
	private String canSee;

	/**
	 * Fields that the user can modify according to its role.
	 */
	private String canModify;
	
	/**
	 * Name of its role.
	 */
	private Role.Name roleName;

	/**
	 * @param user
	 * @param canSee
	 * @param canModify
	 * @param roleName
	 */
	public UserRoleDTO(UserDTO user, String canSee, String canModify, Role.Name roleName) {
		this.user = user;
		this.canSee = canSee;
		this.canModify = canModify;
		this.roleName = roleName;
	}

	/**
	 * Empty Constructor
	 */
	public UserRoleDTO() {
	}

	/**
	 * @return the user
	 */
	public UserDTO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
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
	 * @return the roleName
	 */
	public Role.Name getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(Role.Name roleName) {
		this.roleName = roleName;
	}
	
}
