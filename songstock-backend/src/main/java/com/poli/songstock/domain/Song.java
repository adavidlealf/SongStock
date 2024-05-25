package com.poli.songstock.domain;

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
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 32)
	private Long id;
	
	private String title;
	
	private Integer duration;
	
	@Column(name = "album_id", length = 32)
	private Long albumId;

}