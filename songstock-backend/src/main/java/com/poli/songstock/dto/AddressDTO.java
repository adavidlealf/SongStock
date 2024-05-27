package com.poli.songstock.dto;

import java.util.Objects;

public class AddressDTO {
	
	/**
	 * Name of the city
	 */
	private String city;

	/**
	 * Number of the postal code
	 */
	private Integer postalCode;
	
	/**
	 * Identifier of the residence
	 */
	private String address;
	
	/**
	 * Name of the specification
	 */
	private String spec;
	
	/**
	 * text of the observation
	 */
	private String obs;
	
	/**
	 * Number of phone
	 */
	private Integer phone;

	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		return Objects.hash(address, city, obs, phone, postalCode, spec);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(obs, other.obs) && Objects.equals(phone, other.phone)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(spec, other.spec);
	}

	/**
	 * Empty Constructor
	 */
	public AddressDTO() {
		super();
	}
	
	/**
	 * @param city
	 * @param postalCode
	 * @param address
	 * @param spec
	 * @param obs
	 * @param phone
	 */
	public AddressDTO(String city, Integer postalCode, String address, String spec, String obs, Integer phone) {
		super();
		this.city = city;
		this.postalCode = postalCode;
		this.address = address;
		this.spec = spec;
		this.obs = obs;
		this.phone = phone;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the postalCode
	 */
	public Integer getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the spec
	 */
	public String getSpec() {
		return spec;
	}

	/**
	 * @param spec the spec to set
	 */
	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
	
}


