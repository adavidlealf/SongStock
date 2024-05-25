package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Song;


public interface SongRepository extends JpaRepository<Song, Long> {

}
