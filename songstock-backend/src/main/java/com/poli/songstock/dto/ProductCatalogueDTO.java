package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class ProductCatalogueDTO {
	
	/**
	 * List of product album data transfer objects
	 */
	private List<ProductAlbumDTO> albums;

	/**
	 * List of product song data transfer objects
	 */
	private List<ProductSongDTO> songs;

	/**
	 * List of product vinyl data transfer objects
	 */
	private List<ProductVinylDTO> vinyls;
	

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
		ProductCatalogueDTO other = (ProductCatalogueDTO) obj;
		return Objects.equals(albums, other.albums) && Objects.equals(songs, other.songs)
				&& Objects.equals(vinyls, other.vinyls);
	}

	/**
	 * Empty Constructor
	 */
	public ProductCatalogueDTO() {
		super();
	}

	/**
	 * @param albums
	 * @param songs
	 * @param vinyls
	 */
	public ProductCatalogueDTO(List<ProductAlbumDTO> albums, List<ProductSongDTO> songs, List<ProductVinylDTO> vinyls) {
		super();
		this.albums = albums;
		this.songs = songs;
		this.vinyls = vinyls;
	}

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
	
	
	
}
