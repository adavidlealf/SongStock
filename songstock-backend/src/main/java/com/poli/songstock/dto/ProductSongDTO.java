package com.poli.songstock.dto;

import java.util.Objects;

public class ProductSongDTO {
	
	/**
	 * Basic song data transfer object
	 */
	private BasicSongDTO basicSong;

	/**
	 * Price of the song
	 */
	private Double price;
	

	@Override
	public int hashCode() {
		return Objects.hash(basicSong, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSongDTO other = (ProductSongDTO) obj;
		return Objects.equals(basicSong, other.basicSong) && Objects.equals(price, other.price);
	}

	/**
	 * Empty Constructor
	 */
	public ProductSongDTO() {
		super();
	}

	/**
	 * @param basicSong
	 * @param price
	 */
	public ProductSongDTO(BasicSongDTO basicSong, Double price) {
		super();
		this.basicSong = basicSong;
		this.price = price;
	}

	/**
	 * @return the basicSong
	 */
	public BasicSongDTO getBasicSong() {
		return basicSong;
	}

	/**
	 * @param basicSong the basicSong to set
	 */
	public void setBasicSong(BasicSongDTO basicSong) {
		this.basicSong = basicSong;
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
