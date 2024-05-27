package com.poli.songstock.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poli.songstock.domain.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

	/**
	 * Consulta los artistas que tiene una cancion, de acuerdo a la tabla song_artist
	 * @param songId Long id de la cancion
	 * @return List<Artist> lista de artistas de la cancion
	 */
	@Query(value = "SELECT a.* FROM artist a, song s, song_artist sa "
				 + "WHERE sa.song_id = :song_id and sa.artist_id = a.id and s.id = :song_id",
			nativeQuery = true)
	List<Artist> findAllBySong (@Param(value = "song_id") Long songId);
	
	/**
	 * Consulta los artistas que tiene una cancion, de acuerdo a la tabla song_artist
	 * @param songId Long id de la cancion
	 * @return List<Artist> lista de artistas de la cancion
	 */
	@Query(value = "SELECT a.* FROM artist a, album al, album_artist aa "
				 + "WHERE aa.album_id = :album_id and aa.artist_id = a.id and al.id = :album_id",
			nativeQuery = true)
	List<Artist> findAllByAlbum (@Param(value = "album_id") Long albumId);
}
