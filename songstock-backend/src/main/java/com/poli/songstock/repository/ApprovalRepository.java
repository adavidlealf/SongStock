package com.poli.songstock.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Approval;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {

	/**
	 * Obtiene todas las aprobaciones donde los productos son parte de una orden fisica 
	 * especificada por id.
	 * @param orderId Long id de la orden fisica
	 * @return List<Approval> aprobaciones de los productos de la orden fisica.
	 */
	@Query(value = "SELECT a.* FROM approval a, order o, order_product op, product p "
				 + "WHERE o.id = :order_id "
				 + "AND op.order_id = :order_id AND a.object_id = op.product_id "
				 + "AND p.id = op.product_id AND p.is_song = '0' AND p.is_digital = '0'"
				 , nativeQuery = true)
	List<Approval> findAllByPhysicalOrder(@Param(value = "order_id") Long orderId);
}
