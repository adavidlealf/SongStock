package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
