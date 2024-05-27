package com.poli.songstock.dto;

import java.util.Objects;

public class VinylDTO {
	
	/**
	 * Basic vinyl data transfer object for the album
	 */
	private BasicVinylDTO basicVinyl;

	/**
	 * Album data transfer object
	 */
	private AlbumDTO album;

	/**
	 * @param basicVinyl
	 * @param album
	 */
	public VinylDTO(BasicVinylDTO basicVinyl, AlbumDTO album) {
		this.basicVinyl = basicVinyl;
		this.album = album;
	}

	/**
	 * Empty constructor
	 */
	public VinylDTO() {
	}

	/**
	 * @return the basicVinyl
	 */
	public BasicVinylDTO getBasicVinyl() {
		return basicVinyl;
	}

	/**
	 * @param basicVinyl the basicVinyl to set
	 */
	public void setBasicVinyl(BasicVinylDTO basicVinyl) {
		this.basicVinyl = basicVinyl;
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

	@Override
	public int hashCode() {
		return Objects.hash(album, basicVinyl);
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
		return Objects.equals(album, other.album) && Objects.equals(basicVinyl, other.basicVinyl);
	}

}
