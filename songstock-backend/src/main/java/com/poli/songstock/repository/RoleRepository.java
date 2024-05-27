package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

	/**
	 * Consulta el rol de un usuario.
	 * @param roleId Long id del rol
	 * @return Rol rol del usuario
	 */
	@Query(value = "SELECT r.* FROM role r, users u WHERE u.role_id = :role_id and r.id = :role_id", nativeQuery = true)
	Role findByUser(@Param(value = "role_id") Long roleId);
}
