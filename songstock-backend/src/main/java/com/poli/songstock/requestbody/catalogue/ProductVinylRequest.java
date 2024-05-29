package com.poli.songstock.requestbody.catalogue;

public class ProductVinylRequest {

	private String color;
	private Double inches;
	private Integer stock;
	private Long albumId;
	private Long distributorId;
	private Double price;
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
	 * @return the albumId
	 */
	public Long getAlbumId() {
		return albumId;
	}
	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}
	/**
	 * @return the distributorId
	 */
	public Long getDistributorId() {
		return distributorId;
	}
	/**
	 * @param distributorId the distributorId to set
	 */
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
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
