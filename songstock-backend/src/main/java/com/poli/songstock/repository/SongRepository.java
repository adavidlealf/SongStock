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
	
	/**
	 * Consulta la lista de canciones de un consumidor.
	 * @param consumerId Long id del consumidor.
	 * @return List<Song> Lista de canciones del consumidor.
	 */
	@Query(value = "SELECT s.* FROM product p, song s, library l "
				 + "WHERE l.consumer_id = :consumer_id "
				 + "AND p.id = l.product_id AND p.is_digital = '1' AND p.is_song = '1' "
				 + "AND s.id = p.object_id"
				 , nativeQuery = true)
	List<Song> findAllByConsumer(@Param(value = "consumer_id") Long consumerId);
	
	/**
	 * Consulta la lista de canciones de una orden digital.
	 * @param orderId Long id de la orden digital.
	 * @return List<Song> Lista de canciones de la orden.
	 */
	@Query(value = "SELECT s.* FROM song s, order o, order_product op, product p "
				 + "WHERE o.id = :order_id "
				 + "AND op.order_id = :order_id AND p.id = op.product_id "
				 + "AND s.id = p.object_id AND p.is_song = '1' AND p.is_digital = '1'"
				 , nativeQuery = true)
	List<Song> findAllByDigitalOrder(@Param(value = "order_id") Long orderId);
}
