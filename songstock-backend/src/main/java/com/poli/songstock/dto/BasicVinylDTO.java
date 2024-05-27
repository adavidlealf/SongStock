package com.poli.songstock.dto;

import java.util.Objects;

public class BasicVinylDTO {
	
	private String color;
	
	private Double inches;
	
	private Integer stock;
	
	private BasicUserDTO distributor;

	@Override
	public int hashCode() {
		return Objects.hash(color, distributor, inches, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicVinylDTO other = (BasicVinylDTO) obj;
		return Objects.equals(color, other.color) && Objects.equals(distributor, other.distributor)
				&& Objects.equals(inches, other.inches) && Objects.equals(stock, other.stock);
	}

	/**
	 * 
	 */
	public BasicVinylDTO() {
		super();
	}

	/**
	 * @param color
	 * @param inches
	 * @param stock
	 * @param distributor
	 */
	public BasicVinylDTO(String color, Double inches, Integer stock, BasicUserDTO distributor) {
		super();
		this.color = color;
		this.inches = inches;
		this.stock = stock;
		this.distributor = distributor;
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

	/**
	 * @return the inches
	 */
	public Double getInches() {
		return inches;
	}

	/**
	 * @param inches the inches to set
	 */
	public void setInches(Double inches) {
		this.inches = inches;
	}

	/**
	 * @return the stock
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the distributor
	 */
	public BasicUserDTO getDistributor() {
		return distributor;
	}

	/**
	 * @param distributor the distributor to set
	 */
	public void setDistributor(BasicUserDTO distributor) {
		this.distributor = distributor;
	}
	
	
	
}
