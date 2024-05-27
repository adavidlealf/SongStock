package com.poli.songstock.dto;

import java.sql.Date;
import java.util.Objects;

public class BasicOrderDTO {
	
	/**
	 * Date of the item
	 */
	private Date date;

	/**
	 * Observation text
	 */
	private String obs;

	/**
	 * Address data transfer object for the consumer
	 */
	private AddressDTO consumerAddress;

	/**
	 * Color of the item
	 */
	private String color;
	

	@Override
	public int hashCode() {
		return Objects.hash(color, consumerAddress, date, obs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicOrderDTO other = (BasicOrderDTO) obj;
		return Objects.equals(color, other.color) && Objects.equals(consumerAddress, other.consumerAddress)
				&& Objects.equals(date, other.date) && Objects.equals(obs, other.obs);
	}

	/**
	 * Empty Constructor
	 */
	public BasicOrderDTO() {
		super();
	}

	/**
	 * @param date
	 * @param obs
	 * @param consumerAddress
	 * @param color
	 */
	public BasicOrderDTO(Date date, String obs, AddressDTO consumerAddress, String color) {
		super();
		this.date = date;
		this.obs = obs;
		this.consumerAddress = consumerAddress;
		this.color = color;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return the consumerAddress
	 */
	public AddressDTO getConsumerAddress() {
		return consumerAddress;
	}

	/**
	 * @param consumerAddress the consumerAddress to set
	 */
	public void setConsumerAddress(AddressDTO consumerAddress) {
		this.consumerAddress = consumerAddress;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
