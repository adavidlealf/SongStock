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

import com.poli.songstock.domain.Album;
import com.poli.songstock.domain.Product;
import com.poli.songstock.domain.Vinyl;
import com.poli.songstock.dto.BasicVinylDTO;
import com.poli.songstock.dto.ProductAlbumDTO;
import com.poli.songstock.dto.ProductVinylDTO;
import com.poli.songstock.dto.VinylDTO;
import com.poli.songstock.repository.VinylRepository;

@Service
public class VinylService implements VinylRepository {

	@Autowired
	private VinylRepository repository;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	@Lazy
	private CatalogueService catalogueService;

	@Autowired
	private ProductService productService;

	@Autowired
	private UsersService usersService;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Vinyl> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Vinyl> entities) {
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
	public Vinyl getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vinyl getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vinyl getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public <S extends Vinyl> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vinyl> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Vinyl> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Vinyl> findById(Long id) {
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
	public void delete(Vinyl entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Vinyl> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vinyl> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Vinyl> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Vinyl> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Vinyl> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Vinyl> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Vinyl, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una instancia de la entidad Vinyl al DTO de BasicVinyl.
	 * @param vinyl Vinyl instancia de la entidad Vinyl
	 * @return BasicVinylDTO instancia de BasicVinylDTO
	 */
	public BasicVinylDTO castEntityToBasicVinylDto(Vinyl vinyl) {
		BasicVinylDTO basicVinylDTO = new BasicVinylDTO();
		basicVinylDTO.setColor(vinyl.getColor());
		basicVinylDTO.setInches(vinyl.getInches());
		basicVinylDTO.setStock(vinyl.getStock());
		return basicVinylDTO;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Vinyl convertidos en BasicVinylDTO.
	 * @return List<BasicVinylDTO> lista de todos los registros de Vinyl en BasicVinylDTO.
	 */
	public List<BasicVinylDTO> findAllBasicVinylDto(){
		return repository.findAll()
				.stream()
				.map(this::castEntityToBasicVinylDto)
				.collect(Collectors.toList());
	}
	

	/**
	 * Convierte una instancia de la entidad Vinyl al DTO de Vinyl.
	 * @param vinyl Vinyl instancia de la entidad Vinyl
	 * @return VinylDTO instancia de VinylDTO
	 */
	public VinylDTO castEntityToVinylDto(Vinyl vinyl) {
		VinylDTO vinylDTO = new VinylDTO();
		vinylDTO.setBasicVinyl(castEntityToBasicVinylDto(vinyl));
		vinylDTO.setAlbum(albumService.getReferenceAlbumDtoById(vinyl.getAlbumId()));
		return vinylDTO;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Vinyl convertidos en VinylDTO.
	 * @return List<VinylDTO> lista de todos los registros de Vinyl en VinylDTO.
	 */
	public List<VinylDTO> findAllVinylDto(){
		return repository.findAll()
				.stream()
				.map(this::castEntityToVinylDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Vinyl al DTO de ProductVinyl.
	 * @param vinyl Vinyl instancia de la entidad Vinyl
	 * @return ProductVinylDTO instancia de ProductVinylDTO
	 */
	public ProductVinylDTO castEntityToProductVinylDto(Vinyl vinyl) {
		ProductVinylDTO vinylDTO = new ProductVinylDTO();
		vinylDTO.setBasicVinyl(castEntityToBasicVinylDto(vinyl));
		vinylDTO.setPrice(catalogueService.getPriceByVinyl(vinyl.getId()));
		vinylDTO.setDistributor(usersService.findDistributorBasicUserDtoByVinyl(vinyl.getId()));
		return vinylDTO;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Vinyl convertidos en ProductVinylDTO.
	 * @return List<ProductVinylDTO> lista de todos los registros de Vinyl en ProductVinylDTO.
	 */
	public List<ProductVinylDTO> findAllProductVinylDto(){
		return repository.findAll()
				.stream()
				.map(this::castEntityToProductVinylDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Retorna la entidad Vinyl obtenida por id convertida en ProductVinylDTO.
	 * @return ProductVinylDTO instancia de Vinyl obtenido por id en ProductVinylDTO.
	 */
	public ProductVinylDTO getReferenceProductVinylDtoById(Long id){
		return castEntityToProductVinylDto(getReferenceById(id));
	}
	
	@Override
	public List<Vinyl> findAllByConsumer(Long consumerId) {
		return repository.findAllByConsumer(consumerId);
	}
	
	/**
	 * Consulta la lista de vinilos de un consumidor y la retorna de tipo BasicVinylDTO.
	 * @param consumerId Long id del consumidor
	 * @return List<BasicVinylDTO> lista de vinilos del consumidor de tipo BasicVinylDTO.
	 */
	public List<BasicVinylDTO> findAllBasicVinylByConsumer(Long consumerId){
		return findAllByConsumer(consumerId)
				.stream()
				.map(this::castEntityToBasicVinylDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Obtiene el DTO de ProductVinyl a partir de un Product
	 * @param product Product instancia base
	 * @return ProductVinylDTO casteo de la base
	 */
	public ProductVinylDTO castProductToProductVinylDTO(Product product) {
		Vinyl vinyl = getReferenceById(product.getObjectId());
		return castEntityToProductVinylDto(vinyl);
	}
	
	/**
	 * Consulta la lista de vinilos ofrecidos por un distribuidor y la retorna de tipo ProductVinylDTO.
	 * @param distributorId Long id del distribuidor
	 * @return List<ProductVinylDTO> lista de vinilos ofrecidos por el distribuidor de tipo ProductVinylDTO.
	 */
	public List<ProductVinylDTO> findAllProductVinylByDistributor(Long distributorId){
		return productService.findAllVinylsByDistributor(distributorId)
				.stream()
				.map(this::castProductToProductVinylDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<Vinyl> findAllByKartConsumer(Long consumerId) {
		return repository.findAllByKartConsumer(consumerId);
	}
	
	/**
	 * Consulta la lista de vinilos del carrito de un consumidor y la retorna 
	 * de tipo ProductVinylDTO.
	 * @param consumerId Long id del consumidor
	 * @return List<ProductVinylDTO> lista de vinilos del carrito de un consumidor de tipo ProductVinylDTO.
	 */
	public List<ProductVinylDTO> findAllProductVinylByKart(Long consumerId){
		return findAllByKartConsumer(consumerId)
				.stream()
				.map(this::castEntityToProductVinylDto)
				.collect(Collectors.toList());
	}
}
