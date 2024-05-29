package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

	/**
	 * Obtiene la informacion de un usuario por su correo.
	 * @param email String correo unico
	 * @return Users informacion del usuario.
	 */
	@Query(value = "SELECT u.* FROM users u "
				 + "WHERE u.email = :email"
				 , nativeQuery = true)
	Users findByEmail(@Param(value = "email") String email);
}
