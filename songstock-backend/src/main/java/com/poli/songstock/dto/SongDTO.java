package com.poli.songstock.dto;

import java.util.Objects;

public class SongDTO {
	
	private BasicSongDTO basicSong;
	
	private BasicAlbumDTO basicAlbum;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(basicAlbum, basicSong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SongDTO other = (SongDTO) obj;
		return Objects.equals(basicAlbum, other.basicAlbum) && Objects.equals(basicSong, other.basicSong);
	}

	/**
	 * 
	 */
	public SongDTO() {
		super();
	}

	/**
	 * @param basicSong
	 * @param basicAlbum
	 */
	public SongDTO(BasicSongDTO basicSong, BasicAlbumDTO basicAlbum) {
		super();
		this.basicSong = basicSong;
		this.basicAlbum = basicAlbum;
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
	
	
	
}
