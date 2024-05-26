package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
