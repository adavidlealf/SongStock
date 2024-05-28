package com.poli.songstock.dto;

import java.util.Objects;

public class BasicVinylDTO {
	
	/**
	 * Color of the item
	 */
	private String color;

	/**
	 * Size in inches
	 */
	private Double inches;

	/**
	 * Stock quantity
	 */
	private Integer stock;

	/**
	 * @param color
	 * @param inches
	 * @param stock
	 */
	public BasicVinylDTO(String color, Double inches, Integer stock) {
		this.color = color;
		this.inches = inches;
		this.stock = stock;
	}

	/**
	 * Empty Constructor
	 */
	public BasicVinylDTO() {
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

	@Override
	public int hashCode() {
		return Objects.hash(color, inches, stock);
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
		return Objects.equals(color, other.color) && Objects.equals(inches, other.inches)
				&& Objects.equals(stock, other.stock);
	}

}
