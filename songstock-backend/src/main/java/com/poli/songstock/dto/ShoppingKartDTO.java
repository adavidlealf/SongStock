package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class ShoppingKartDTO {

	/**
	 * Albums to buy later
	 */
	private List<ProductAlbumDTO> albums;
	
	/**
	 * Songs to buy later
	 */
	private List<ProductSongDTO> songs;
	
	/**
	 * Vinyls to buy later
	 */
	private List<ProductVinylDTO> vinyls;

	/**
	 * @return the albums
	 */
	public List<ProductAlbumDTO> getAlbums() {
		return albums;
	}

	/**
	 * @param albums the albums to set
	 */
	public void setAlbums(List<ProductAlbumDTO> albums) {
		this.albums = albums;
	}

	/**
	 * @return the songs
	 */
	public List<ProductSongDTO> getSongs() {
		return songs;
	}

	/**
	 * @param songs the songs to set
	 */
	public void setSongs(List<ProductSongDTO> songs) {
		this.songs = songs;
	}

	/**
	 * @return the vinyls
	 */
	public List<ProductVinylDTO> getVinyls() {
		return vinyls;
	}

	/**
	 * @param vinyls the vinyls to set
	 */
	public void setVinyls(List<ProductVinylDTO> vinyls) {
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
		ShoppingKartDTO other = (ShoppingKartDTO) obj;
		return Objects.equals(albums, other.albums) && Objects.equals(songs, other.songs)
				&& Objects.equals(vinyls, other.vinyls);
	}

	/**
	 * @param albums
	 * @param songs
	 * @param vinyls
	 */
	public ShoppingKartDTO(List<ProductAlbumDTO> albums, List<ProductSongDTO> songs, List<ProductVinylDTO> vinyls) {
		this.albums = albums;
		this.songs = songs;
		this.vinyls = vinyls;
	}

	/**
	 * Empty constructor
	 */
	public ShoppingKartDTO() {
	}
	
}
