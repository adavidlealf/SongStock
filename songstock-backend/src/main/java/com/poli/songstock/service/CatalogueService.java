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
import com.poli.songstock.dto.CatalogueDTO;
import com.poli.songstock.repository.CatalogueRepository;

@Service
public class CatalogueService implements CatalogueRepository {

	@Autowired
	private CatalogueRepository repository;
	
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
		return repository.save(entity);
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
		if(c==null) return null;
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

	/**
	 * Obtiene todo el catalogo del sistema, buscando todos los productos cancion, album, y vinilo.
	 * @return CatalogueDTO catalogo instanciado con todas los productos cancion, album, y vinilo.
	 */
	public CatalogueDTO getAllCatalogueDto() {
		CatalogueDTO catalogueDTO = new CatalogueDTO();
		catalogueDTO.setAlbums(albumService.findAllProductAlbumDTO());
		catalogueDTO.setSongs(songService.findAllProductSongDto());
		catalogueDTO.setVinyls(vinylService.findAllProductVinylDto());
		return catalogueDTO;
	}
	
	/**
	 * Obtiene todo el catalogo de productos ofrecidos por un distribuidor por su id.
	 * @param consumerId Long id del distribuidor
	 * @return CatalogueDTO catalogo ofrecido por un distribuidor.
	 */
	public CatalogueDTO getCatalogueDtoByDistributor(Long distributorId) {
		CatalogueDTO dto = new CatalogueDTO();
		dto.setSongs(songService.findAllProductSongByDistributor(distributorId));
		dto.setAlbums(albumService.findAllProductAlbumByDistributor(distributorId));
		dto.setVinyls(vinylService.findAllProductVinylByDistributor(distributorId));
		return dto;
	}

	@Override
	public List<Catalogue> findAllByOrder(Long orderId) {
		return repository.findAllByOrder(orderId);
	}
	
	/**
	 * Calcular el costo total de una lista de productos de una orden.
	 * @param orderId Long id de la orden
	 * @return Double suma de los precios de los productos de la orden.
	 */
	public Double getTotalByOrder(Long orderId) {
		return getTotal(findAllByOrder(orderId));
	}
	
	/**
	 * Calcular el costo total de una lista de productos.
	 * @param productos List<Catalogue> lista de productos
	 * @return Double suma de los precios de los productos
	 */
	public Double getTotal(List<Catalogue> productos) {
		Double total = 0.0;
		for(Catalogue c : productos) {
			total += (c.getPrice());
		}
		return total;
	}
}
