package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class CatalogueDTO {
	
	/**
	 * List of product album data transfer objects
	 */
	private List<AlbumDTO> albums;

	/**
	 * List of product song data transfer objects
	 */
	private List<SongDTO> songs;

	/**
	 * List of product vinyl data transfer objects
	 */
	private List<VinylDTO> vinyls;

	/**
	 * @return the albums
	 */
	public List<AlbumDTO> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	public void setAlbums(List<AlbumDTO> albums) {
		this.albums = albums;
	}

	/**
	 * @return the songs
	 */
	public List<SongDTO> getSongs() {
		return songs;
	}

	/**
	 * @param songs the songs to set
	 */
	public void setSongs(List<SongDTO> songs) {
		this.songs = songs;
	}

	/**
	 * @return the vinyls
	 */
	public List<VinylDTO> getVinyls() {
		return vinyls;
	}

	/**
	 * @param vinyls the vinyls to set
	 */
	public void setVinyls(List<VinylDTO> vinyls) {
		this.vinyls = vinyls;
	}

	/**
	 * 
	 */
	public CatalogueDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param albums
	 * @param songs
	 * @param vinyls
	 */
	public CatalogueDTO(List<AlbumDTO> albums, List<SongDTO> songs, List<VinylDTO> vinyls) {
		this.albums = albums;
		this.songs = songs;
		this.vinyls = vinyls;
	}
	
}
