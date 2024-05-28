package com.poli.songstock.dto;

import java.util.Objects;

public class ProductAlbumDTO {
	
	/**
	 * Basic album data transfer object
	 */
	private BasicAlbumDTO basicAlbum;

	/**
	 * Price of the album
	 */
	private Double price;
	
	/**
	 * Distributor of the album
	 */
	private BasicUserDTO distributor;

	/**
	 * @param basicAlbum
	 * @param price
	 * @param distributor
	 */
	public ProductAlbumDTO(BasicAlbumDTO basicAlbum, Double price, BasicUserDTO distributor) {
		this.basicAlbum = basicAlbum;
		this.price = price;
		this.distributor = distributor;
	}

	/**
	 * Empty constructor
	 */
	public ProductAlbumDTO() {
	}

	/**
	 * @return the basicAlbum
	 */
	public BasicAlbumDTO getBasicAlbum() {
		return basicAlbum;
	}

	/**
	 * @param basicAlbum the basicAlbum to set
	 */
	public void setBasicAlbum(BasicAlbumDTO basicAlbum) {
		this.basicAlbum = basicAlbum;
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
		return Objects.hash(basicAlbum, distributor, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductAlbumDTO other = (ProductAlbumDTO) obj;
		return Objects.equals(basicAlbum, other.basicAlbum) && Objects.equals(distributor, other.distributor)
				&& Objects.equals(price, other.price);
	}

}
