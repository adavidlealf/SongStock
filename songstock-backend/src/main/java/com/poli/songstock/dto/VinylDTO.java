package com.poli.songstock.dto;

import java.util.Objects;

public class VinylDTO {
	
	private BasicVinylDTO albumVinyl;
	
	private AlbumDTO album;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(album, albumVinyl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VinylDTO other = (VinylDTO) obj;
		return Objects.equals(album, other.album) && Objects.equals(albumVinyl, other.albumVinyl);
	}

	/**
	 * 
	 */
	public VinylDTO() {
		super();
	}

	/**
	 * @param albumVinyl
	 * @param album
	 */
	public VinylDTO(BasicVinylDTO albumVinyl, AlbumDTO album) {
		super();
		this.albumVinyl = albumVinyl;
		this.album = album;
	}

	/**
	 * @return the albumVinyl
	 */
	public BasicVinylDTO getAlbumVinyl() {
		return albumVinyl;
	}

	/**
	 * @param albumVinyl the albumVinyl to set
	 */
	public void setAlbumVinyl(BasicVinylDTO albumVinyl) {
		this.albumVinyl = albumVinyl;
	}

	/**
	 * @return the album
	 */
	public AlbumDTO getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(AlbumDTO album) {
		this.album = album;
	}
	
	
	
}
