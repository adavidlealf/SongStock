package com.poli.songstock.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.poli.songstock.domain.Catalogue;
import com.poli.songstock.repository.CatalogueRepository;

@Service
public class CatalogueService implements CatalogueRepository {

	@Autowired
	private CatalogueRepository repository;
	
	/**
	 * Patron Singleton.
	 */
	private static CatalogueService instance;
	
	/**
	 * Obtener instancia de patron singleton.
	 * @return
	 */
	public static CatalogueService getInstance() {
		if(instance == null) {
			instance = new CatalogueService();
		}
		return instance;
	}
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Catalogue> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Catalogue> entities) {
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
	public Catalogue getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalogue> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Catalogue> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Catalogue> findById(Long id) {
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
	public void delete(Catalogue entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Catalogue> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Catalogue> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Catalogue> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Catalogue> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Catalogue> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Catalogue> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Catalogue, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue findBySong(Long songId) {
		return repository.findBySong(songId);
	}

	@Override
	public Catalogue findByAlbum(Long albumId) {
		return repository.findByAlbum(albumId);
	}

	@Override
	public Catalogue findByVinyl(Long vinylId) {
		return repository.findByVinyl(vinylId);
	}
	
	/**
	 * Obtiene el precio de una cancion dado su id.
	 * @param songId Long id de la cancion
	 * @return Double precio de la cancion
	 */
	public Double getPriceBySong(Long songId) {
		Catalogue c = findBySong(songId);
		return c.getPrice();
	}
	
	/**
	 * Obtiene el precio de un album dado su id.
	 * @param albumId Long id de la album
	 * @return Double precio de la album
	 */
	public Double getPriceByAlbum(Long albumId) {
		Catalogue c = findByAlbum(albumId);
		return c.getPrice();
	}
	
	/**
	 * Obtiene el precio de un vinilo dado su id.
	 * @param viniloId Long id de la vinilo
	 * @return Double precio de la vinilo
	 */
	public Double getPriceByVinyl(Long vinylId) {
		Catalogue c = findByVinyl(vinylId);
		return c.getPrice();
	}

}
