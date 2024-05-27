package com.poli.songstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	/**
	 * Consulta todas las direcciones que tiene un usuario especifico.
	 * @param userId Long id del usuario.
	 * @return List<Address> lista de las direcciones del usuario.
	 */
	@Query(value = "SELECT a.* FROM users u, address a WHERE a.user_id = :user_id and u.id = :user_id", nativeQuery = true)
	List<Address> findAllByUser(@Param(value = "user_id") Long userId);
	
}
