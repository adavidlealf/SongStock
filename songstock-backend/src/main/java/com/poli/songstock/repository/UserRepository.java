package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
