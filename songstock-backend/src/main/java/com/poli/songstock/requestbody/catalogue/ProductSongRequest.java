package com.poli.songstock.requestbody.catalogue;

public class ProductSongRequest {
	private String title;
	private Integer duration;
	private Long albumId;
	private String artists;
	private Long distributorId;
	private Double price;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
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
	 * @return the artists
	 */
	public String getArtists() {
		return artists;
	}
	/**
	 * @param artists the artists to set
	 */
	public void setArtists(String artists) {
		this.artists = artists;
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
