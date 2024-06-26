package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class UserDTO {	
	
	/**
	 * Basic user data transfer object
	 */
	private BasicUserDTO basicUser;

	/**
	 * List of address data transfer objects
	 */
	private List<AddressDTO> addresses;

	/**
	 * Email address
	 */
	private String email;

	/**
	 * Password for authentication
	 */
	private String password;
	

	@Override
	public int hashCode() {
		return Objects.hash(addresses, basicUser, email, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(addresses, other.addresses) && Objects.equals(basicUser, other.basicUser)
				&& Objects.equals(email, other.email) && Objects.equals(password, other.password);
	}

	/**
	 * Empty Constructor
	 */
	public UserDTO() {
		super();
	}

	/**
	 * @param basicUser
	 * @param addresses
	 * @param email
	 * @param password
	 */
	public UserDTO(BasicUserDTO basicUser, List<AddressDTO> addresses, String email, String password) {
		super();
		this.basicUser = basicUser;
		this.addresses = addresses;
		this.email = email;
		this.password = password;
	}

	/**
	 * @return the basicUser
	 */
	public BasicUserDTO getBasicUser() {
		return basicUser;
	}

	/**
	 * @param basicUser the basicUser to set
	 */
	public void setBasicUser(BasicUserDTO basicUser) {
		this.basicUser = basicUser;
	}

	/**
	 * @return the addresses
	 */
	public List<AddressDTO> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<AddressDTO> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
