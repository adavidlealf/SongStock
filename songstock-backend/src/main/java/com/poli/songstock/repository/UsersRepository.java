package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {

}
