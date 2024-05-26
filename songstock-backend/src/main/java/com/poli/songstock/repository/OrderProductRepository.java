package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
