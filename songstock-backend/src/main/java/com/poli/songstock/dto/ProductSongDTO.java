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
	
	/**
	 * Distributor of the song
	 */
	private BasicUserDTO distributor;

	/**
	 * @param basicSong
	 * @param price
	 * @param distributor
	 */
	public ProductSongDTO(BasicSongDTO basicSong, Double price, BasicUserDTO distributor) {
		this.basicSong = basicSong;
		this.price = price;
		this.distributor = distributor;
	}

	/**
	 * Empty constructor
	 */
	public ProductSongDTO() {
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
		return Objects.hash(basicSong, distributor, price);
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
		return Objects.equals(basicSong, other.basicSong) && Objects.equals(distributor, other.distributor)
				&& Objects.equals(price, other.price);
	}

}
