package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

	/**
	 * Busca un usuario distribuidor que tiene un vinilo.
	 * @param distributorId Long id del distribuidor.
	 * @return Users distribuidor del vinilo.
	 */
	@Query(value = "SELECT u.* FROM users u, vinyl v "
				 + "WHERE v.distributor_id = :distributor_id and u.id = :distributor_id", 
			nativeQuery = true)
	Users findDistributorByVinyl(@Param(value = "distributor_id") Long distributorId);
}
