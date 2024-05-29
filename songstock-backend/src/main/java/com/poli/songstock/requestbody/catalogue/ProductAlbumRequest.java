package com.poli.songstock.requestbody.catalogue;

import java.util.Date;

public class ProductAlbumRequest {
	private String name;
	private Date releaseDate;
	private String coverUrl;
	private String artists;
	private Long distributorId;
	private Double price;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}
	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	/**
	 * @return the coverUrl
	 */
	public String getCoverUrl() {
		return coverUrl;
	}
	/**
	 * @param coverUrl the coverUrl to set
	 */
	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
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
