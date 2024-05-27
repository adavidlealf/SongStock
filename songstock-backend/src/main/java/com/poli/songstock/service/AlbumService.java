package com.poli.songstock.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

import com.poli.songstock.domain.Album;
import com.poli.songstock.domain.Song;
import com.poli.songstock.dto.AlbumDTO;
import com.poli.songstock.dto.BasicAlbumDTO;
import com.poli.songstock.dto.BasicSongDTO;
import com.poli.songstock.repository.AlbumRepository;

@Service
public class AlbumService implements AlbumRepository{
	
	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private ArtistService artistService;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Album> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Album> entities) {
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
	public Album getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Album> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Album> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Album> findById(Long id) {
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
	public void delete(Album entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Album> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Album> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Album> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Album> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Album> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Album> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Album, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Convierte una instancia de la entidad Album al DTO de BasicAlbum.
	 * @param album Album instancia de la entidad Album
	 * @return BasicAlbumDTO instancia de BasicAlbumDTO
	 */
	public BasicAlbumDTO castEntityToBasicAlbumDto(Album album) {
		BasicAlbumDTO basicAlbumDTO = new BasicAlbumDTO();
		basicAlbumDTO.setName(album.getName());
		if(album.getReleaseDate()!=null) {
			basicAlbumDTO.setReleaseDate(Date.from(
				album.getReleaseDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
			));
		}
		basicAlbumDTO.setCoverUrl(album.getCoverUrl());
		basicAlbumDTO.setArtists(artistService.findAllBasicArtistDtoByAlbum(album.getId()));
		return basicAlbumDTO;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Album convertidos en BasicAlbumDTO.
	 * @return List<BasicAlbumDTO> lista de todos los registros de Album en BasicAlbumDTO.
	 */
	public List<BasicAlbumDTO> findAllBasicAlbumDTO() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToBasicAlbumDto)
				.collect(Collectors.toList());
	}
	
}
