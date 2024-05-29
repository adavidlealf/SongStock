package com.poli.songstock.service;

import java.time.ZoneId;
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

import com.poli.songstock.domain.Orders;
import com.poli.songstock.dto.BasicOrderDTO;
import com.poli.songstock.dto.DigitalOrderDTO;
import com.poli.songstock.dto.PhysicalOrderDTO;
import com.poli.songstock.repository.OrdersRepository;

@Service
public class OrdersService implements OrdersRepository {

	@Autowired
	private OrdersRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired 
	private ApprovalService approvalService;
	
	@Autowired
	private CatalogueService catalogueService;

	@Autowired
	private SongService songService;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Orders> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Orders> entities) {
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
	public Orders getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Orders> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Orders> findById(Long id) {
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
	public void delete(Orders entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Orders> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Orders> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Orders> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Orders> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Orders> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Orders> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Orders, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una instancia de la entidad Order al DTO de BasicOrder.
	 * @param ent Orders entidad
	 * @return BasicOrderDTO dto
	 */
	public BasicOrderDTO castEntityToBasicOrderDto(Orders ent) {
		BasicOrderDTO dto = new BasicOrderDTO();
		if(ent.getDate()!=null) {
			dto.setDate(
					Date.from(ent.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant())
				);
		}
		dto.setObs(ent.getObs());
		dto.setConsumerAddress(addressService.getReferenceAddressDtoById(ent.getAddressId()));
		dto.setTotal(catalogueService.getTotalByOrder(ent.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Orders convertidos en BasicOrderDTO.
	 * @return List<BasicOrderDTO> lista de todos los registros de Orders en BasicOrderDTO.
	 */
	public List<BasicOrderDTO> findAllBasicOrderDto(){
		return findAll()
				.stream()
				.map(this::castEntityToBasicOrderDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Order al DTO de PhysicalOrder.
	 * @param ent Orders entidad
	 * @return PhysicalOrderDTO dto
	 */
	public PhysicalOrderDTO castEntityToPhysicalOrderDto(Orders ent) {
		PhysicalOrderDTO dto = new PhysicalOrderDTO();
		dto.setBasicOrder(castEntityToBasicOrderDto(ent));
		dto.setApprovals(approvalService.findAllApprovalDtoByPhysicalOrder(ent.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Orders convertidos en PhysicalOrderDTO.
	 * @return List<PhysicalOrderDTO> lista de todos los registros de Orders en PhysicalOrderDTO.
	 */
	public List<PhysicalOrderDTO> findAllPhysicalOrderDto(){
		return findAll()
				.stream()
				.map(this::castEntityToPhysicalOrderDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Order al DTO de DigitalOrder.
	 * @param ent Orders entidad
	 * @return DigitalOrderDTO dto
	 */
	public DigitalOrderDTO castEntityToDigitalOrderDto(Orders ent) {
		DigitalOrderDTO dto = new DigitalOrderDTO();
		dto.setBasicOrder(castEntityToBasicOrderDto(ent));
		dto.setProductAlbums(albumService.findAllProductAlbumByDigitalOrder(ent.getId()));
		dto.setProductSongs(songService.findAllProductSongByDigitalOrder(ent.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Orders convertidos en DigitalOrderDTO.
	 * @return List<DigitalOrderDTO> lista de todos los registros de Orders en DigitalOrderDTO.
	 */
	public List<DigitalOrderDTO> findAllDigitalOrderDto(){
		return findAll()
				.stream()
				.map(this::castEntityToDigitalOrderDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Orders> findAllByConsumer(Long consumerId) {
		return repository.findAllByConsumer(consumerId);
	}
	
	/**
	 * Retorna una lista de las ordenes de un consumidor convertidos en DigitalOrderDTO.
	 * @return List<DigitalOrderDTO> lista de las ordenes de un consumidor en DigitalOrderDTO.
	 */
	public List<DigitalOrderDTO> findAllDigitalOrderDtoByConsumer(Long consumerId){
		return findAllByConsumer(consumerId)
				.stream()
				.map(this::castEntityToDigitalOrderDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Retorna una lista de las ordenes de un consumidor convertidos en PhysicalOrderDTO.
	 * @return List<PhysicalOrderDTO> lista de las ordenes de un consumidor en PhysicalOrderDTO.
	 */
	public List<PhysicalOrderDTO> findAllPhysicalOrderDtoByConsumer(Long consumerId){
		return findAllByConsumer(consumerId)
				.stream()
				.map(this::castEntityToPhysicalOrderDto)
				.collect(Collectors.toList());
	}
}
