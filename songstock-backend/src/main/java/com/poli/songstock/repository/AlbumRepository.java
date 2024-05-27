package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {

	/**
	 * Consulta el album de una cancion.
	 * @param songId Long id de la cancion.
	 * @return Album album de la cancion.
	 */
	@Query(value = "SELECT a.* FROM album a, song s "
				 + "WHERE s.id = :song_id AND s.album_id = a.id"
				 , nativeQuery = true)
	Album findBySong(@Param(value = "song_id") Long songId);
}
