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
	

	@Override
	public int hashCode() {
		return Objects.hash(basicAlbum, price);
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
		return Objects.equals(basicAlbum, other.basicAlbum) && Objects.equals(price, other.price);
	}

	/**
	 * Empty Constructor
	 */
	public ProductAlbumDTO() {
		super();
	}

	/**
	 * @param basicAlbum
	 * @param price
	 */
	public ProductAlbumDTO(BasicAlbumDTO basicAlbum, Double price) {
		super();
		this.basicAlbum = basicAlbum;
		this.price = price;
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
	
	
	
}
