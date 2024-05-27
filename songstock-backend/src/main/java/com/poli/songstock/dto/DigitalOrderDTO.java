package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class DigitalOrderDTO {
	
	/**
	 * Basic order data transfer object
	 */
	private BasicOrderDTO basicOrder;

	/**
	 * List of product song data transfer objects
	 */
	private List<ProductSongDTO> productSongs;

	/**
	 * List of product album data transfer objects
	 */
	private List<ProductAlbumDTO> productAlbums;
	

	@Override
	public int hashCode() {
		return Objects.hash(basicOrder, productAlbums, productSongs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigitalOrderDTO other = (DigitalOrderDTO) obj;
		return Objects.equals(basicOrder, other.basicOrder) && Objects.equals(productAlbums, other.productAlbums)
				&& Objects.equals(productSongs, other.productSongs);
	}

	/**
	 * Empty Constructor
	 */
	public DigitalOrderDTO() {
		super();
	}

	/**
	 * @param basicOrder
	 * @param productSongs
	 * @param productAlbums
	 */
	public DigitalOrderDTO(BasicOrderDTO basicOrder, List<ProductSongDTO> productSongs,
			List<ProductAlbumDTO> productAlbums) {
		super();
		this.basicOrder = basicOrder;
		this.productSongs = productSongs;
		this.productAlbums = productAlbums;
	}

	/**
	 * @return the basicOrder
	 */
	public BasicOrderDTO getBasicOrder() {
		return basicOrder;
	}

	/**
	 * @param basicOrder the basicOrder to set
	 */
	public void setBasicOrder(BasicOrderDTO basicOrder) {
		this.basicOrder = basicOrder;
	}

	/**
	 * @return the productSongs
	 */
	public List<ProductSongDTO> getProductSongs() {
		return productSongs;
	}

	/**
	 * @param productSongs the productSongs to set
	 */
	public void setProductSongs(List<ProductSongDTO> productSongs) {
		this.productSongs = productSongs;
	}

	/**
	 * @return the productAlbums
	 */
	public List<ProductAlbumDTO> getProductAlbums() {
		return productAlbums;
	}

	/**
	 * @param productAlbums the productAlbums to set
	 */
	public void setProductAlbums(List<ProductAlbumDTO> productAlbums) {
		this.productAlbums = productAlbums;
	}
	
	
	
}
