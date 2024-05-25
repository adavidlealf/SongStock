package com.poli.songstock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Library;


public interface LibraryRepository extends JpaRepository<Library, Long> {

}
