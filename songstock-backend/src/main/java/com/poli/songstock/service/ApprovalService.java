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

import com.poli.songstock.domain.Approval;
import com.poli.songstock.dto.ApprovalConsumerDTO;
import com.poli.songstock.dto.ApprovalDTO;
import com.poli.songstock.dto.ApprovalDistributorDTO;
import com.poli.songstock.repository.ApprovalRepository;

@Service
public class ApprovalService implements ApprovalRepository{
	
	@Autowired
	private ApprovalRepository repository;

	@Autowired
	@Lazy
	private UsersService usersService;
	
	@Autowired
	private VinylService vinylService;

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Approval> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Approval> entities) {
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
	public Approval getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Approval getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Approval getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Approval> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Approval> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Approval> findById(Long id) {
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
	public void delete(Approval entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Approval> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Approval> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Approval> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Approval> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Approval> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Approval> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Approval, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Convierte una instancia de la entidad Approval al DTO de Approval.
	 * @param approval Approval instancia de la entidad Approval
	 * @return ApprovalDTO instancia de ApprovalDTO
	 */
	public ApprovalDTO castEntityToApprovalDto(Approval approval) {
		ApprovalDTO dto = new ApprovalDTO();
		dto.setTitle(approval.getTitle());
		dto.setObs(approval.getObs());
		if(approval.getApplicantDate()!=null) {
			dto.setApplicationDate(Date.from(
					approval.getApplicantDate().atStartOfDay(ZoneId.systemDefault()).toInstant()
			));
		}
		dto.setState(approval.getState());
		dto.setCode(approval.getCode());
		dto.setVinyl(vinylService.getReferenceProductVinylDtoById(approval.getObjectId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Approval convertidos en ApprovalDTO.
	 * @return List<ApprovalDTO> lista de todos los registros de Approval en ApprovalDTO.
	 */
	public List<ApprovalDTO> findAllApprovalDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToApprovalDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Approval> findAllByPhysicalOrder(Long orderId) {
		return repository.findAllByPhysicalOrder(orderId);
	}
	
	/**
	 * Retorna una lista de las aprobaciones de productos de una orden fisica convertidos 
	 * en ApprovalDTO.
	 * @param orderId Long id de la orden fisica 
	 * @return List<ApprovalDTO> lista de aprobaciones de productos de una orden fisica. 
	 */
	public List<ApprovalDTO> findAllApprovalDtoByPhysicalOrder(Long orderId) {
		return findAllByPhysicalOrder(orderId)
				.stream()
				.map(this::castEntityToApprovalDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Approval al DTO de ApprovalDistributor.
	 * @param approval Approval instancia de la entidad Approval
	 * @return ApprovalDistributorDTO instancia de ApprovalDistributorDTO
	 */
	public ApprovalDistributorDTO castEntityToApprovalDistributorDto(Approval ent) {
		ApprovalDistributorDTO dto = new ApprovalDistributorDTO();
		dto.setApproval(castEntityToApprovalDto(ent));
		dto.setApplicant(usersService.getReferenceBasicUserDtoById(ent.getApplicantId()));
		return dto;
	}

	/**
	 * Retorna una lista de las aprobaciones convertidas en ApprovalDistributorDTO.
	 * @return List<ApprovalDistributorDTO> lista de aprobaciones tipo ApprovalDistributorDto. 
	 */
	public List<ApprovalDistributorDTO> findAllApprovalDistributorDto() {
		return findAll()
				.stream()
				.map(this::castEntityToApprovalDistributorDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Approval al DTO de ApprovalConsumer.
	 * @param approval Approval instancia de la entidad Approval
	 * @return ApprovalConsumerDTO instancia de ApprovalConsumerDTO
	 */
	public ApprovalConsumerDTO castEntityToApprovalConsumerDto(Approval ent) {
		ApprovalConsumerDTO dto = new ApprovalConsumerDTO();
		dto.setApproval(castEntityToApprovalDto(ent));
		dto.setApprover(usersService.getReferenceBasicUserDtoById(ent.getApproverId()));
		return dto;
	}

	/**
	 * Retorna una lista de las aprobaciones convertidas en ApprovalConsumerDTO.
	 * @return List<ApprovalConsumerDTO> lista de aprobaciones tipo ApprovalConsumerDto. 
	 */
	public List<ApprovalConsumerDTO> findAllApprovalConsumerDto() {
		return findAll()
				.stream()
				.map(this::castEntityToApprovalConsumerDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<Approval> findAllByApplicant(Long applicantId) {
		return repository.findAllByApplicant(applicantId);
	}
	
	/**
	 * Retorna una lista de las aprobaciones de un usuario solicitante convertidas en ApprovalConsumerDTO.
	 * @return List<ApprovalConsumerDTO> lista de aprobaciones tipo ApprovalConsumerDto. 
	 */
	public List<ApprovalConsumerDTO> findAllApprovalConsumerDtoByApplicant(Long applicantId) {
		return findAllByApplicant(applicantId)
				.stream()
				.map(this::castEntityToApprovalConsumerDto)
				.collect(Collectors.toList());
	}
}
