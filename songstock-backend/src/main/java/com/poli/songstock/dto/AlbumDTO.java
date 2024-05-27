package com.poli.songstock.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AlbumDTO {

	/**
	 * Name of the album
	 */
	private BasicAlbumDTO basicAlbum;

	private List<BasicSongDTO> songs;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(basicAlbum, songs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumDTO other = (AlbumDTO) obj;
		return Objects.equals(basicAlbum, other.basicAlbum) && Objects.equals(songs, other.songs);
	}

	/**
	 * 
	 */
	public AlbumDTO() {
		super();
	}

	/**
	 * @param basicAlbum
	 * @param songs
	 */
	public AlbumDTO(BasicAlbumDTO basicAlbum, List<BasicSongDTO> songs) {
		super();
		this.basicAlbum = basicAlbum;
		this.songs = songs;
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
	
	

	
}
