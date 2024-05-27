package com.poli.songstock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue,Long> {

	/**
	 * Busca el precio de una cancion por su id.
	 * @param songId Long id de la cancion
	 * @return Catalogue instancia de Catalogue el cual contiene el precio de la cancion
	 */
	@Query(value = "SELECT c.* FROM catalogue c, product p, song s "
			 + "WHERE s.id = :song_id "
			 + "AND p.is_digital = '1' AND p.is_song = '1' AND p.object_id = :song_id "
			 + "AND c.product_id = p.id"
			 , nativeQuery = true)
	Catalogue findBySong(@Param(value = "song_id") Long songId);
	
	/**
	 * Busca el precio de un album por su id.
	 * @param albumId Long id de la album
	 * @return Catalogue instancia de Catalogue el cual contiene el precio del album
	 */
	@Query(value = "SELECT c.* FROM catalogue c, product p, album a "
			 + "WHERE a.id = :album_id "
			 + "AND p.is_digital = '1' AND p.is_song = '0' AND p.object_id = :album_id "
			 + "AND c.product_id = p.id"
			 , nativeQuery = true)
	Catalogue findByAlbum(@Param(value = "album_id") Long albumId);
	
	/**
	 * Busca el precio de un vinilo por su id.
	 * @param vinylId Long id de la vinilo
	 * @return Catalogue instancia de Catalogue el cual contiene el precio del vinilo
	 */
	@Query(value = "SELECT c.* FROM catalogue c, product p, vinyl v "
			 + "WHERE v.id = :vinyl_id "
			 + "AND p.is_digital = '0' AND p.is_song = '0' AND p.object_id = :vinyl_id "
			 + "AND c.product_id = p.id"
			 , nativeQuery = true)
	Catalogue findByVinyl(@Param(value = "vinyl_id") Long vinylId);
}
