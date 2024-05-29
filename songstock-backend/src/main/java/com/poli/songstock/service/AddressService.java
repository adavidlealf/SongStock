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

import com.poli.songstock.domain.Address;
import com.poli.songstock.dto.AddressDTO;
import com.poli.songstock.repository.AddressRepository;

@Service
public class AddressService implements AddressRepository {
	
	@Autowired
	private AddressRepository repository;

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Address> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Address> entities) {
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
	public Address getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Address> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Address> findById(Long id) {
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
	public void delete(Address entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Address> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Address> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Address> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Address> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Address> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Address> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Address, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Convierte una instancia de la entidad Address al DTO de Address.
	 * @param address Address instancia de la entidad
	 * @return AddressDTO instancia del DTO
	 */
	public AddressDTO castEntityToAddressDto(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setCity(address.getCity());
		addressDTO.setPostalCode(address.getPostalCode());
		addressDTO.setAddress(address.getAddress());
		addressDTO.setSpec(address.getSpec());
		addressDTO.setObs(address.getObs());
		addressDTO.setPhone(address.getPhone());
		return addressDTO;
	}

	/**
	 * Retorna una lista de todos los registros de la entidad Address convertidos en DTO.
	 * @return List<AddressDTO> lista de todos los registros de Address en DTO.
	 */
	public List<AddressDTO> findAllAddressDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToAddressDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Address> findAllByUser(Long userId) {
		return repository.findAllByUser(userId);
	}

	/**
	 * Retorna una lista de todas las direcciones de un usuario convertidos en AddressDTO.
	 * @return List<AddressDTO> lista de direcciones de un usuario en AddressDTO.
	 */
	public List<AddressDTO> findAllAddressDtoByUser(Long id) {
		return findAllByUser(id)
				.stream()
				.map(this::castEntityToAddressDto)
				.collect(Collectors.toList());
	}
	
}
