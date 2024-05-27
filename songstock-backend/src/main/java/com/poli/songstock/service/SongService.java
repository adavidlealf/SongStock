package com.poli.songstock.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.poli.songstock.domain.Song;
import com.poli.songstock.dto.BasicSongDTO;
import com.poli.songstock.dto.SongDTO;
import com.poli.songstock.repository.SongRepository;

@Service
public class SongService implements SongRepository{
	
	@Autowired
	private SongRepository repository;
	
	/**
	 * Patron Singleton.
	 */
	private static SongService instance;
	
	/**
	 * Obtener instancia de patron singleton.
	 * @return
	 */
	public static SongService getInstance() {
		if(instance == null) {
			instance = new SongService();
		}
		return instance;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Song> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Song> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Song getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Song> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Song> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Song> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Song entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Song> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Song> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Song> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Song> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Song> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Song> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Song, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una instancia de la entidad Song al DTO de BasicSong.
	 * @param song Song instancia de la entidad Song
	 * @return BasicSongDTO instancia de BasicSongDTO
	 */
	public BasicSongDTO castEntityToBasicSongDto(Song song) {
		BasicSongDTO dto = new BasicSongDTO();
		dto.setDuration(song.getDuration());
		dto.setTitle(song.getTitle());
		dto.setArtists(ArtistService.getInstance()
				.findAllBasicArtistDtoBySong(song.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Song convertidos en BasicSongDTO.
	 * @return List<BasicSongDTO> lista de todos los registros de Song en BasicSongDTO.
	 */
	public List<BasicSongDTO> findAllBasicSongDto() {
		return findAll()
				.stream()
				.map(this::castEntityToBasicSongDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Song al DTO de Song.
	 * @param song Song instancia de la entidad Song
	 * @return SongDTO instancia de SongDTO
	 */
	public SongDTO castEntityToSongDto(Song song) {
		SongDTO dto = new SongDTO();
		dto.setBasicSong(castEntityToBasicSongDto(song));
		dto.setBasicAlbum(AlbumService.getInstance()
				.findBasicAlbumDtoBySong(song.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Song convertidos en SongDTO.
	 * @return List<SongDTO> lista de todos los registros de Song en SongDTO.
	 */
	public List<SongDTO> findAllSongDto() {
		return findAll()
				.stream()
				.map(this::castEntityToSongDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Song> findAllByAlbum(Long albumId) {
		return repository.findAllByAlbum(albumId);
	}
	
	/**
	 * Consulta las canciones de un album y las retorna en una lista de BasicSongDTO.
	 * @param albumId Long id del album
	 * @return List<BasicSongDTO> canciones del album.
	 */
	public List<BasicSongDTO> findAllBasicSongDtoByAlbum(Long albumId) {
		return findAllByAlbum(albumId)
				.stream()
				.map(this::castEntityToBasicSongDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Song> findAllByArtist(Long artistId) {
		return repository.findAllByArtist(artistId);
	}
	
	/**
	 * Consulta las canciones de un artista y las retorna en una lista de SongDTO.
	 * @param albumId Long id del artista
	 * @return List<SongDTO> canciones del artista.
	 */
	public List<SongDTO> findAllSongDtoByArtist(Long artistId) {
		return findAllByArtist(artistId)
				.stream()
				.map(this::castEntityToSongDto)
				.collect(Collectors.toList());
	}
}
