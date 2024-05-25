package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.AlbumArtist;


public interface AlbumArtistRepository extends JpaRepository<AlbumArtist, Long> {

}
