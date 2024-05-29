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

import com.poli.songstock.domain.ShoppingKart;
import com.poli.songstock.dto.ShoppingKartDTO;
import com.poli.songstock.repository.ShoppingKartRepository;

@Service
public class ShoppingKartService implements ShoppingKartRepository {

	@Autowired
	private ShoppingKartRepository repository;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private VinylService vinylService;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends ShoppingKart> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<ShoppingKart> entities) {
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
	public ShoppingKart getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingKart getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingKart getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingKart> findAll() {
		return repository.findAll();
	}

	@Override
	public List<ShoppingKart> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ShoppingKart> findById(Long id) {
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
	public void delete(ShoppingKart entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends ShoppingKart> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ShoppingKart> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ShoppingKart> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends ShoppingKart> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends ShoppingKart> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends ShoppingKart> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends ShoppingKart, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Obtiene el carrito de compras de un usuario consumidor y lo retorna en el dto.
	 * @param idConsumer Long id del usuario 
	 * @return ShoppingKartDTO dto del carrito del consumidor.
	 */
	public ShoppingKartDTO getShoppingKartDtoByConsumer(Long idConsumer) {
		ShoppingKartDTO dto = new ShoppingKartDTO();
		dto.setSongs(songService.findAllProductSongByKart(idConsumer));
		dto.setAlbums(albumService.findAllProductAlbumByKart(idConsumer));
		dto.setVinyls(vinylService.findAllProductVinylByKart(idConsumer));
		return dto;
	}
}
