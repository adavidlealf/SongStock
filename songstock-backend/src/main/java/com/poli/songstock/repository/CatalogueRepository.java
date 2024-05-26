package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poli.songstock.domain.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue,Long> {

}
