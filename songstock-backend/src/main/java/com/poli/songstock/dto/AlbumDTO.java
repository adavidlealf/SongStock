package com.poli.songstock.dto;

import java.util.Date;
import java.util.List;

public class AlbumDTO {

	/**
	 * Name of the album
	 */
	private String name;
	
	private Date releaseDate;
	
	private String coverUrl;
	
	private List<BasicSongDTO> songs;

	private List<BasicArtistDTO> artist;

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
	 * @return the songs
	 */
	public List<BasicSongDTO> getSongs() {
		return songs;
	}

	/**
	 * @param songs the songs to set
	 */
	public void setSongs(List<BasicSongDTO> songs) {
		this.songs = songs;
	}

	/**
	 * @return the artist
	 */
	public List<BasicArtistDTO> getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(List<BasicArtistDTO> artist) {
		this.artist = artist;
	}
	
}
