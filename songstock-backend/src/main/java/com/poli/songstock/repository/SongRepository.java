package com.poli.songstock.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Song;


public interface SongRepository extends JpaRepository<Song, Long> {

	/**
	 * Consulta las canciones de un album.
	 * @param albumId Long id del album.
	 * @return List<Song> canciones del album.
	 */
	@Query(value = "SELECT s.* FROM album a, song s "
				 + "WHERE a.id = :album_id AND s.album_id = :album_id"
				 , nativeQuery = true)
	List<Song> findAllByAlbum(@Param(value = "album_id") Long albumId);
	
	/**
	 * Consulta las canciones de un artista.
	 * @param artistId Long id del artista.
	 * @return List<Song> canciones del artista.
	 */
	@Query(value = "SELECT s.* FROM artist a, song s, song_artist sa "
				 + "WHERE a.id = :artist_id AND sa.artist_id = :artist_id AND s.id = sa.song_id"
				 , nativeQuery = true)
	List<Song> findAllByArtist(@Param(value = "artist_id") Long artistId);
}
