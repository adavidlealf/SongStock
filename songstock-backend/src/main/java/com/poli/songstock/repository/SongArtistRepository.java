package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.SongArtist;


public interface SongArtistRepository extends JpaRepository<SongArtist, Long> {

}
