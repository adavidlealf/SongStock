package com.poli.songstock.controller;

import java.util.ArrayList;
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

import com.poli.songstock.model.AprobacionDTO;
import com.poli.songstock.repository.AprobacionRepository;

@Service
public class AprobacionController implements AprobacionRepository{

	@Autowired
	private AprobacionRepository repository;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
	}

	@Override
	public <S extends AprobacionDTO> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<AprobacionDTO> entities) {
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
	public AprobacionDTO getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AprobacionDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AprobacionDTO getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AprobacionDTO> findAll() {
		return repository.findAll();
	}

	@Override
	public List<AprobacionDTO> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<AprobacionDTO> findById(Long id) {
		return repository.findById(id);
	}
	
	public List<AprobacionDTO> findByEstado(String estado){
		List<AprobacionDTO> todos = repository.findAll();
		List<AprobacionDTO> retorno = new ArrayList<AprobacionDTO>();
		for(AprobacionDTO apro : todos) {
			if(apro.getEstado().equals(estado)) {
				retorno.add(apro);
			}
		}
		return retorno;
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
	public void delete(AprobacionDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends AprobacionDTO> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AprobacionDTO> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AprobacionDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends AprobacionDTO> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends AprobacionDTO> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends AprobacionDTO> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends AprobacionDTO, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

}
