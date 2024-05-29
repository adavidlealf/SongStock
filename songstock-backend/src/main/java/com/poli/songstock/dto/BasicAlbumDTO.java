package com.poli.songstock.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BasicAlbumDTO {
	
	/**
	 * Id of the album
	 */
	private Long id;
	
	/**
	 * Name of the item
	 */
	private String name;

	/**
	 * Release date of the item
	 */
	private Date releaseDate;

	/**
	 * URL for the cover image
	 */
	private String coverUrl;

	/**
	 * List of basic artist data transfer objects
	 */
	private List<BasicArtistDTO> artists;


	@Override
	public int hashCode() {
		return Objects.hash(artists, coverUrl, name, releaseDate, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicAlbumDTO other = (BasicAlbumDTO) obj;
		return Objects.equals(artists, other.artists) && Objects.equals(coverUrl, other.coverUrl)
				&& Objects.equals(name, other.name) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(id, other.id);
	}

	/**
	 * Empty Constructor
	 */
	public BasicAlbumDTO() {
		super();
	}

	/**
	 * @param name
	 * @param releaseDate
	 * @param coverUrl
	 * @param artists
	 */
	public BasicAlbumDTO(Long id, String name, Date releaseDate, String coverUrl, List<BasicArtistDTO> artists) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.coverUrl = coverUrl;
		this.artists = artists;
		this.id = id;
	}

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
	public List<BasicArtistDTO> getArtists() {
		return artists;
	}

	/**
	 * @param artists the artists to set
	 */
	public void setArtists(List<BasicArtistDTO> artists) {
		this.artists = artists;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
}
