package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class ArtistDTO {
	
	/**
	 * Basic artist data transfer object
	 */
	private BasicArtistDTO basicArtist;

	/**
	 * List of song data transfer objects
	 */
	private List<SongDTO> songs;


	@Override
	public int hashCode() {
		return Objects.hash(basicArtist, songs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistDTO other = (ArtistDTO) obj;
		return Objects.equals(basicArtist, other.basicArtist)
				&& Objects.equals(songs, other.songs);
	}

	/**
	 * Empty Constructor
	 */
	public ArtistDTO() {
		super();
	}

	/**
	 * @param basicArtist
	 * @param songs
	 */
	public ArtistDTO(BasicArtistDTO basicArtist, List<SongDTO> songs) {
		super();
		this.basicArtist = basicArtist;
		this.songs = songs;
	}

	/**
	 * @return the basicArtist
	 */
	public BasicArtistDTO getBasicArtist() {
		return basicArtist;
	}

	/**
	 * @param basicArtist the basicArtist to set
	 */
	public void setBasicArtist(BasicArtistDTO basicArtist) {
		this.basicArtist = basicArtist;
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
	
}