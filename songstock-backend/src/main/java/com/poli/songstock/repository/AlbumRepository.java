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
	
	/**
	 * Consulta la lista de albumes de una orden digital.
	 * @param orderId Long id de la orden digital.
	 * @return List<Album> Lista de albumes de la orden.
	 */
	@Query(value = "SELECT a.* FROM album a, order o, order_product op, product p "
				 + "WHERE o.id = :order_id "
				 + "AND op.order_id = :order_id AND p.id = op.product_id "
				 + "AND a.id = p.object_id AND p.is_song = '0' AND p.is_digital = '1'"
				 , nativeQuery = true)
	List<Album> findAllByDigitalOrder(@Param(value = "order_id") Long orderId);
	
	/**
	 * Consulta la lista de albumes que un consumidor tiene en su carrito.
	 * @param consumerId Long id del consumidor.
	 * @return List<Album> Lista de albumes del carrito consumidor.
	 */
	@Query(value = "SELECT a.* FROM users u, shopping_kart k, album a, product p "
				 + "WHERE u.id = :consumer_id AND k.consumer_id = :consumer_id "
				 + "AND p.id = k.product_id AND a.id = p.object_id "
				 + "AND p.is_song = '0' AND p.is_digital = '1'"
				 , nativeQuery = true)
	List<Album> findAllByKartConsumer(@Param(value = "consumer_id") Long consumerId);
}
