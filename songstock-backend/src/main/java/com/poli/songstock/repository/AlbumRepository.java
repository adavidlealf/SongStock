package com.poli.songstock.repository;


import java.util.List;

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
	
	/**
	 * Consulta la lista de albumes de un consumidor.
	 * @param consumerId Long id del consumidor.
	 * @return List<Album> Lista de albumes del consumidor.
	 */
	@Query(value = "SELECT a.* FROM product p, album a, library l "
				 + "WHERE l.consumer_id = :consumer_id "
				 + "AND p.id = l.product_id AND p.is_digital = '1' AND p.is_song = '0' "
				 + "AND a.id = p.object_id"
				 , nativeQuery = true)
	List<Album> findAllByConsumer(@Param(value = "consumer_id") Long consumerId);
}
