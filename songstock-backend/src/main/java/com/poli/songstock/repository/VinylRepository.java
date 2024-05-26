package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Vinyl;

public interface VinylRepository extends JpaRepository<Vinyl, Long> {

}
