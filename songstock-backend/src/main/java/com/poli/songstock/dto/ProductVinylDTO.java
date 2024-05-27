package com.poli.songstock.dto;

import java.util.Objects;

public class ProductVinylDTO {

	private BasicVinylDTO basicVinyl;
	
	private Double price;

	@Override
	public int hashCode() {
		return Objects.hash(basicVinyl, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductVinylDTO other = (ProductVinylDTO) obj;
		return Objects.equals(basicVinyl, other.basicVinyl) && Objects.equals(price, other.price);
	}

	/**
	 * 
	 */
	public ProductVinylDTO() {
		super();
	}

	/**
	 * @param basicVinyl
	 * @param price
	 */
	public ProductVinylDTO(BasicVinylDTO basicVinyl, Double price) {
		super();
		this.basicVinyl = basicVinyl;
		this.price = price;
	}

	/**
	 * @return the basicVinyl
	 */
	public BasicVinylDTO getBasicVinyl() {
		return basicVinyl;
	}

	/**
	 * @param basicVinyl the basicVinyl to set
	 */
	public void setBasicVinyl(BasicVinylDTO basicVinyl) {
		this.basicVinyl = basicVinyl;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}

