package com.poli.songstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Busca el producto asociado a un vinilo.
	 * @param vinylId Long id del vinilo.
	 * @return Product producto del vinilo.
	 */
	@Query(value = "SELECT p.* FROM product p, vinyl v "
				 + "WHERE v.id = :vinyl_id "
				 + "AND p.object_id = v.id AND p.is_digital = '0' AND p.is_song = '0'"
		 , nativeQuery = true)
	Product findByVinyl(@Param(value = "vinyl_id") Long vinylId);
	
	/**
	 * Busca el producto asociado a un album.
	 * @param albumId Long id del album.
	 * @return Product producto del album.
	 */
	@Query(value = "SELECT p.* FROM product p, album a "
				 + "WHERE a.id = :album_id "
				 + "AND p.object_id = a.id AND p.is_digital = '1' AND p.is_song = '0'"
		 , nativeQuery = true)
	Product findByAlbum(@Param(value = "album_id") Long albumId);
	
	/**
	 * Busca el producto asociado a una cancion.
	 * @param songId Long id de la cancion.
	 * @return Product producto del cancion.
	 */
	@Query(value = "SELECT p.* FROM product p, song s "
				 + "WHERE s.id = :song_id "
				 + "AND p.object_id = s.id AND p.is_digital = '1' AND p.is_song = '1'"
		 , nativeQuery = true)
	Product findBySong(@Param(value = "song_id") Long songId);
	
	/**
	 * Busca todos los productos tipo cancion.
	 * @return List<Product> lista de productos tipo cancion.
	 */
	@Query(value = "SELECT p.* FROM product p, song s "
				 + "WHERE p.object_id = s.id AND p.is_digital = '1' AND p.is_song = '1'"
		 , nativeQuery = true)
	List<Product> findAllSongs();
	
	/**
	 * Busca todos los productos tipo album.
	 * @return List<Product> lista de productos tipo album.
	 */
	@Query(value = "SELECT p.* FROM product p, album a "
				 + "WHERE p.object_id = a.id AND p.is_digital = '1' AND p.is_song = '0'"
		 , nativeQuery = true)
	List<Product> findAllAlbums();
	
	/**
	 * Busca todos los productos tipo vinilo.
	 * @return List<Product> lista de productos tipo vinilo.
	 */
	@Query(value = "SELECT p.* FROM product p, vinyl v "
				 + "WHERE p.object_id = v.id AND p.is_digital = '0' AND p.is_song = '0'"
		 , nativeQuery = true)
	List<Product> findAllVinyls();
	
	/**
	 * Busca todos los productos tipo cancion de un distribuidor por su id
	 * @param distributorId Long id del distribuidor
	 * @return List<Product> lista de productos tipo cancion.
	 */
	@Query(value = "SELECT p.* FROM product p, song s "
			+ "WHERE p.object_id = s.id "
			+ "AND p.is_digital = '1' AND p.is_song = '1' AND p.distributor_id = :distributor_id"
			, nativeQuery = true)
	List<Product> findAllSongsByDistributor(@Param(value = "distributor_id") Long distributorId);
	
	/**
	 * Busca todos los productos tipo album de un distribuidor por su id.
	 * @param distributorId Long id del distribuidor
	 * @return List<Product> lista de productos tipo album de un distribuidor por su id.
	 */
	@Query(value = "SELECT p.* FROM product p, album a "
			+ "WHERE p.object_id = a.id "
			+ "AND p.is_digital = '1' AND p.is_song = '0' AND p.distributor_id = :distributor_id"
			, nativeQuery = true)
	List<Product> findAllAlbumsByDistributor(@Param(value = "distributor_id") Long distributorId);
	
	/**
	 * Busca todos los productos tipo vinilo de un distribuidor por su id.
	 * @param distributorId Long id del distribuidor
	 * @return List<Product> lista de productos tipo vinilo de un distribuidor por su id.
	 */
	@Query(value = "SELECT p.* FROM product p, vinyl v "
			+ "WHERE p.object_id = v.id "
			+ "AND p.is_digital = '0' AND p.is_song = '0' AND p.distributor_id = :distributor_id"
			, nativeQuery = true)
	List<Product> findAllVinylsByDistributor(@Param(value = "distributor_id") Long distributorId);
}
