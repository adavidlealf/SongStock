package com.poli.songstock.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumArtist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 32)
	private Long id;
	
	@Column(name = "album_id", length = 32)
	private Long albumId;
	
	@Column(name = "artist_id", length = 32)
	private Long artistId;

}