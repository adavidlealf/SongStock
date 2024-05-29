package com.poli.songstock.dto;

import java.util.List;
import java.util.Objects;

public class BasicSongDTO {

	/**
	 * Id del song
	 */
	private Long id;
	
	/**
	 * Title of the item
	 */
	private String title;

	/**
	 * Duration of the item (in seconds)
	 */
	private Integer duration;

	/**
	 * List of basic artist data transfer objects
	 */
	private List<BasicArtistDTO> artists;
	

	@Override
	public int hashCode() {
		return Objects.hash(artists, duration, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasicSongDTO other = (BasicSongDTO) obj;
		return Objects.equals(artists, other.artists) && Objects.equals(duration, other.duration)
				&& Objects.equals(title, other.title) && Objects.equals(id, other.id);
	}

	/**
	 * Empty Constructor
	 */
	public BasicSongDTO() {
		super();
	}

	/**
	 * @param title
	 * @param duration
	 * @param artists
	 */
	public BasicSongDTO(String title, Integer duration, List<BasicArtistDTO> artists, Long id) {
		super();
		this.title = title;
		this.duration = duration;
		this.artists = artists;
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the artists
	 */
	public List<BasicArtistDTO> getArtists() {
		return artists;
	}

	/**
	 * @param artists the artists to set
	 */
	public void setArtists(List<BasicArtistDTO> artists) {
		this.artists = artists;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
