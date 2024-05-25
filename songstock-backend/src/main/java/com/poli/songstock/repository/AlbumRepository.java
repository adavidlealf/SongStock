package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {

}
