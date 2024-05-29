package com.poli.songstock.service;

import java.time.ZoneId;
import java.util.Date;
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

import com.poli.songstock.domain.Album;
import com.poli.songstock.domain.Product;
import com.poli.songstock.dto.AlbumDTO;
import com.poli.songstock.dto.BasicAlbumDTO;
import com.poli.songstock.dto.ProductAlbumDTO;
import com.poli.songstock.repository.AlbumRepository;

@Service
public class AlbumService implements AlbumRepository{
	
	@Autowired
	private AlbumRepository repository;
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	@Lazy
	private CatalogueService catalogueService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	@Lazy
	private SongService songService;
	
	@Autowired
	private UsersService usersService;
	
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
		return repository.getReferenceById(id);
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

	@Override
	public Album findBySong(Long songId) {
		return repository.findBySong(songId);
	}
	
	/**
	 * Consulta el album de una cancion y retorna el BasicAlbumDTO.
	 * @param songId Long id de la cancion.
	 * @return BasicAlbumDTO instancia de BasicAlbumDTO de una cancion.
	 */
	public BasicAlbumDTO findBasicAlbumDtoBySong(Long songId) {
		return castEntityToBasicAlbumDto(findBySong(songId));
	}
	
	/**
	 * Convierte una instancia de la entidad Album al DTO de Album.
	 * @param album Album instancia de la entidad Album
	 * @return AlbumDTO instancia de AlbumDTO
	 */
	public AlbumDTO castEntityToAlbumDto(Album album) {
		AlbumDTO albumDTO = new AlbumDTO();
		albumDTO.setBasicAlbum(castEntityToBasicAlbumDto(album));
		albumDTO.setSongs(songService.findAllBasicSongDtoByAlbum(album.getId()));
		return albumDTO;
	}
	
	/**
	 * Busca una instancia de la entidad Album por su id y lo convierte al DTO de Album.
	 * @param album Album instancia de la entidad Album
	 * @return id Long id del album
	 */
	public AlbumDTO getReferenceAlbumDtoById(Long id) {
		return castEntityToAlbumDto(getReferenceById(id));
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Album convertidos en AlbumDTO.
	 * @return List<AlbumDTO> lista de todos los registros de Album en AlbumDTO.
	 */
	public List<AlbumDTO> findAllAlbumDTO() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToAlbumDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Album al DTO de ProductAlbum.
	 * @param album Album instancia de la entidad Album
	 * @return ProductAlbumDTO instancia de ProductAlbumDTO
	 */
	public ProductAlbumDTO castEntityToProductAlbumDto(Album album) {
		ProductAlbumDTO productAlbumDTO = new ProductAlbumDTO();
		productAlbumDTO.setBasicAlbum(castEntityToBasicAlbumDto(album));
		productAlbumDTO.setPrice(catalogueService.getPriceByAlbum(album.getId()));
		productAlbumDTO.setDistributor(usersService.findDistributorBasicUserDtoByAlbum(album.getId()));
		return productAlbumDTO;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Album convertidos en ProductAlbumDTO.
	 * @return List<ProductAlbumDTO> lista de todos los registros de Album en ProductAlbumDTO.
	 */
	public List<ProductAlbumDTO> findAllProductAlbumDTO() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToProductAlbumDto)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<Album> findAllByConsumer(Long consumerId) {
		return repository.findAllByConsumer(consumerId);
	}
	
	/**
	 * Consulta la lista de albumes de un consumidor y la retorna de tipo BasicAlbumDTO.
	 * @param consumerId Long id del consumidor
	 * @return List<BasicAlbumDTO> lista de albumes del consumidor de tipo BasicAlbumDTO.
	 */
	public List<BasicAlbumDTO> findAllBasicAlbumByConsumer(Long consumerId){
		return findAllByConsumer(consumerId)
				.stream()
				.map(this::castEntityToBasicAlbumDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Obtiene el DTO de ProductAlbum a partir de un Product
	 * @param product Product instancia base
	 * @return ProductAlbumDTO casteo de la base
	 */
	public ProductAlbumDTO castProductToProductAlbumDTO(Product product) {
		Album album = getReferenceById(product.getObjectId());
		return castEntityToProductAlbumDto(album);
	}
	
	
	/**
	 * Consulta la lista de albumes ofrecidos por un distribuidor y la retorna de tipo ProductAlbumDTO.
	 * @param distributorId Long id del distribuidor
	 * @return List<ProductAlbumDTO> lista de albumes ofrecidos por el distribuidor de tipo ProductAlbumDTO.
	 */
	public List<ProductAlbumDTO> findAllProductAlbumByDistributor(Long distributorId){
		return productService.findAllAlbumsByDistributor(distributorId)
				.stream()
				.map(this::castProductToProductAlbumDTO)
				.collect(Collectors.toList());
	}
	
}
