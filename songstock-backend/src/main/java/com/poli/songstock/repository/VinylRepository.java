package com.poli.songstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Vinyl;

public interface VinylRepository extends JpaRepository<Vinyl, Long> {
	
	/**
	 * Consulta la lista de vinilos de un consumidor.
	 * @param consumerId Long id del consumidor.
	 * @return List<Vinyl> Lista de vinilos del consumidor.
	 */
	@Query(value = "SELECT v.* FROM product p, vinyl v, library l "
				 + "WHERE l.consumer_id = :consumer_id "
				 + "AND p.id = l.product_id AND p.is_digital = '0' AND p.is_song = '0' "
				 + "AND v.id = p.object_id"
				 , nativeQuery = true)
	List<Vinyl> findAllByConsumer(@Param(value = "consumer_id") Long consumerId);
	
	/**
	 * Consulta la lista de vinilos que un consumidor tiene en su carrito.
	 * @param consumerId Long id del consumidor.
	 * @return List<Vinyl> Lista de vinilos del carrito consumidor.
	 */
	@Query(value = "SELECT v.* FROM users u, shopping_kart k, vinyl v, product p "
				 + "WHERE u.id = :consumer_id AND k.consumer_id = :consumer_id "
				 + "AND p.id = k.product_id AND v.id = p.object_id "
				 + "AND p.is_song = '0' AND p.is_digital = '0'"
				 , nativeQuery = true)
	List<Vinyl> findAllByKartConsumer(@Param(value = "consumer_id") Long consumerId);
}
