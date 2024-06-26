package com.poli.songstock.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.poli.songstock.domain.Artist;
import com.poli.songstock.dto.ArtistDTO;
import com.poli.songstock.dto.BasicArtistDTO;
import com.poli.songstock.repository.ArtistRepository;

@Service
public class ArtistService implements ArtistRepository {

	@Autowired
	private ArtistRepository repository;
	
	@Autowired
	@Lazy
	private SongService songService;

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Artist> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Artist> entities) {
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
	public Artist getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public <S extends Artist> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artist> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Artist> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<Artist> findById(Long id) {
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
	public void delete(Artist entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Artist> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Artist> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Artist> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Artist> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Artist> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Artist> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Artist, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Convierte una instancia de la entidad Artist al DTO de BasicArtist.
	 * @param artist Artist instancia de la entidad Artist
	 * @return BasicArtistDTO instancia de BasicArtistDTO
	 */
	public BasicArtistDTO castEntityToBasicArtistDto(Artist artist) {
		if(artist == null) return null;
		BasicArtistDTO basicArtistDTO = new BasicArtistDTO();
		basicArtistDTO.setId(artist.getId());
		basicArtistDTO.setName(artist.getName());
		return basicArtistDTO;
	}
	
	/**
	 * Obtiene un artista por id y lo retorna tipo BasicArtistDTO
	 * @param id Long id del artista
	 * @return BasicArtistDTO dto
	 */
	public BasicArtistDTO getReferenceBasicArtistDtoById(Long id) {
		return castEntityToBasicArtistDto(getReferenceById(id));
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Artist convertidos en BasicArtistDTO.
	 * @return List<BasicArtistDTO> lista de todos los registros de Artist en BasicArtistDTO.
	 */
	public List<BasicArtistDTO> findAllBasicArtistDto(){
		return repository.findAll()
				.stream()
				.map(this::castEntityToBasicArtistDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Artist> findAllBySong(Long songId) {
		return repository.findAllBySong(songId);
	}
	
	/**
	 * Retorna una lista de artistas de una cancion convertidos en BasicArtistDTO.
	 * @param songId Long id de la cancion.
	 * @return List<BasicArtistDTO> lista de los artistas de una cancion en BasicArtistDTO.
	 */
	public List<BasicArtistDTO> findAllBasicArtistDtoBySong(Long songId) {
		return findAllBySong(songId)
				.stream()
				.map(this::castEntityToBasicArtistDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Artist> findAllByAlbum(Long albumId) {
		return repository.findAllByAlbum(albumId);
	}

	/**
	 * Retorna una lista de artistas de un album convertidos en BasicArtistDTO.
	 * @param albumId Long id del album.
	 * @return List<BasicArtistDTO> lista de los artistas de un album en BasicArtistDTO.
	 */
	public List<BasicArtistDTO> findAllBasicArtistDtoByAlbum(Long albumId) {
		return findAllByAlbum(albumId)
				.stream()
				.map(this::castEntityToBasicArtistDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Artist al DTO de Artist.
	 * @param artist Artist instancia de la entidad Artist
	 * @return ArtistDTO instancia de ArtistDTO
	 */
	public ArtistDTO castEntityToArtistDto(Artist artist) {
		ArtistDTO artistDTO = new ArtistDTO();
		artistDTO.setBasicArtist(castEntityToBasicArtistDto(artist));
		artistDTO.setSongs(songService.findAllSongDtoByArtist(artist.getId()));
		return artistDTO;
	}
	
	/**
	 * Obtiene un artista por id y lo retorna tipo ArtistDTO
	 * @param id Long id del artista
	 * @return ArtistDTO dto
	 */
	public ArtistDTO getReferenceArtistDtoById(Long id) {
		return castEntityToArtistDto(getReferenceById(id));
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Artist convertidos en ArtistDTO.
	 * @return List<ArtistDTO> lista de todos los registros de Artist en ArtistDTO.
	 */
	public List<ArtistDTO> findAllArtistDto(){
		return repository.findAll()
				.stream()
				.map(this::castEntityToArtistDto)
				.collect(Collectors.toList());
	}

	@Override
	public Artist findByName(String name) {
		return repository.findByName(name);
	}
	
	/**
	 * Busca un artista por su nombre y lo retorna en tipo BasicArtistDTO.
	 * @param name String nombre
	 * @return BasicArtistDTO info basica
	 */
	public BasicArtistDTO findBasicArtistByName(String name) {
		return castEntityToBasicArtistDto(findByName(name));
	}
}
