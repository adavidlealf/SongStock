package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
