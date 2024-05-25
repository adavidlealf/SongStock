package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
