package com.poli.songstock.dto;

import java.util.Objects;

public class ProductVinylDTO {

	/**
	 * Basic vinyl data transfer object
	 */
	private BasicVinylDTO basicVinyl;

	/**
	 * Price of the vinyl
	 */
	private Double price;

	/**
	 * Distributor of the vinyl
	 */
	private BasicUserDTO distributor;

	/**
	 * @param basicVinyl
	 * @param price
	 * @param distributor
	 */
	public ProductVinylDTO(BasicVinylDTO basicVinyl, Double price, BasicUserDTO distributor) {
		this.basicVinyl = basicVinyl;
		this.price = price;
		this.distributor = distributor;
	}

	/**
	 * Empty constructor
	 */
	public ProductVinylDTO() {
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

	@Override
	public int hashCode() {
		return Objects.hash(basicVinyl, distributor, price);
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
		return Objects.equals(basicVinyl, other.basicVinyl) && Objects.equals(distributor, other.distributor)
				&& Objects.equals(price, other.price);
	}

}

