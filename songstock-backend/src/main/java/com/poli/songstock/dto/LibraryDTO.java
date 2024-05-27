package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class LibraryDTO {
	
	/**
	 * List of basic song data transfer objects
	 */
	private List<BasicSongDTO> songs;

	/**
	 * List of basic album data transfer objects
	 */
	private List<BasicAlbumDTO> albums;

	/**
	 * List of basic vinyl data transfer objects
	 */
	private List<BasicVinylDTO> vinyls;

	/**
	 * @param songs
	 * @param albums
	 * @param vinyls
	 */
	public LibraryDTO(List<BasicSongDTO> songs, List<BasicAlbumDTO> albums, List<BasicVinylDTO> vinyls) {
		this.songs = songs;
		this.albums = albums;
		this.vinyls = vinyls;
	}

	/**
	 * Empty constructor 
	 */
	public LibraryDTO() {
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
	 * @return the albums
	 */
	public List<BasicAlbumDTO> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	public void setAlbums(List<BasicAlbumDTO> albums) {
		this.albums = albums;
	}

	/**
	 * @return the vinyls
	 */
	public List<BasicVinylDTO> getVinyls() {
		return vinyls;
	}

	/**
	 * @param vinyls the vinyls to set
	 */
	public void setVinyls(List<BasicVinylDTO> vinyls) {
		this.vinyls = vinyls;
	}

	@Override
	public int hashCode() {
		return Objects.hash(albums, songs, vinyls);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryDTO other = (LibraryDTO) obj;
		return Objects.equals(albums, other.albums) && Objects.equals(songs, other.songs)
				&& Objects.equals(vinyls, other.vinyls);
	}
	
}
