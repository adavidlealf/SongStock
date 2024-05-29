package com.poli.songstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

	/**
	 * Consulta las ordenes de un usuario consumidor por su id.
	 * @param consumerId Long id del usuario consumidor.
	 * @return List<Orders> ordenes del consumidor .
	 */
	@Query(value = "SELECT o.* FROM orders o, users u, address a "
				 + "WHERE u.id = :consumer_id "
				 + "AND a.user_id = :consumer_id "
				 + "AND o.address_id = a.id"
				 , nativeQuery = true)
	List<Orders> findAllByConsumer(@Param(value = "consumer_id") Long consumerId);
}
