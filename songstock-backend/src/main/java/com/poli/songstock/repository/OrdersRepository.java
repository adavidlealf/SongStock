package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long> {

}
