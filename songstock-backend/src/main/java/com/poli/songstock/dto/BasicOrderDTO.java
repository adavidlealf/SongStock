package com.poli.songstock.dto;

import java.util.Date;
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
	 * Total of the products
	 */
	private Double total;

	/**
	 * @param date
	 * @param obs
	 * @param consumerAddress
	 * @param total
	 */
	public BasicOrderDTO(Date date, String obs, AddressDTO consumerAddress, Double total) {
		this.date = date;
		this.obs = obs;
		this.consumerAddress = consumerAddress;
		this.total = total;
	}

	/**
	 * Empty constructor
	 */
	public BasicOrderDTO() {
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
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		return Objects.hash(consumerAddress, date, obs, total);
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
		return Objects.equals(consumerAddress, other.consumerAddress) && Objects.equals(date, other.date)
				&& Objects.equals(obs, other.obs) && Objects.equals(total, other.total);
	}
	
}
