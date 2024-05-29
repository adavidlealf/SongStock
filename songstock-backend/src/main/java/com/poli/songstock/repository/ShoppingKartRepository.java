package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.ShoppingKart;

public interface ShoppingKartRepository extends JpaRepository<ShoppingKart, Long> {

}
