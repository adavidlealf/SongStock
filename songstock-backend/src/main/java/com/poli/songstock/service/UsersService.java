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

import com.poli.songstock.domain.Product;
import com.poli.songstock.domain.Role;
import com.poli.songstock.domain.Users;
import com.poli.songstock.dto.BasicUserDTO;
import com.poli.songstock.dto.ConsumerDTO;
import com.poli.songstock.dto.DistributorDTO;
import com.poli.songstock.dto.UserDTO;
import com.poli.songstock.dto.UserRoleDTO;
import com.poli.songstock.repository.UsersRepository;

@Service
public class UsersService implements UsersRepository{
	
	@Autowired
	private UsersRepository repository;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ApprovalService approvalService;
	
	@Autowired
	private CatalogueService catalogueService;
	
	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Users> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Users> entities) {
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
	public Users getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getReferenceById(Long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Users> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> S save(S entity) {
		return repository.save(entity);
	}

	@Override
	public Optional<Users> findById(Long id) {
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
	public void delete(Users entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Users> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Users> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Users> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Users, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Convierte una instancia de la entidad Users al DTO de BasicUser.
	 * @param user Users instancia de la entidad Users
	 * @return BasicUserDTO instancia de BasicUserDTO
	 */
	public BasicUserDTO castEntityToBasicUserDto(Users user) {
		BasicUserDTO basicUserDTO = new BasicUserDTO();
		basicUserDTO.setName(user.getName());
		basicUserDTO.setNickname(user.getNickname());
		return basicUserDTO;
	}

	/**
	 * Retorna una lista de todos los registros de la entidad Users convertidos en BasicUserDTO.
	 * @return List<BasicUserDTO> lista de todos los registros de Users en BasicUserDTO.
	 */
	public List<BasicUserDTO> findAllBasicUserDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToBasicUserDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Users al DTO de User.
	 * @param user Users instancia de la entidad Users
	 * @return UserDTO instancia de UserDTO
	 */
	public UserDTO castEntityToUserDto(Users user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setBasicUser(castEntityToBasicUserDto(user));
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setAddresses(addressService.findAllAddressDtoByUser(user.getId()));
		return userDTO;
	}

	/**
	 * Retorna una lista de todos los registros de la entidad Users convertidos en UserDTO.
	 * @return List<UserDTO> lista de todos los registros de Users en UserDTO.
	 */
	public List<UserDTO> findAllUserDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToUserDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Users al DTO de UserRole.
	 * @param user Users instancia de la entidad Users
	 * @return UserRoleDTO instancia de UserRoleDTO
	 */
	public UserRoleDTO castEntityToUserRoleDto(Users user) {
		UserRoleDTO userRoleDTO = new UserRoleDTO();
		userRoleDTO.setUser(castEntityToUserDto(user));
		Role role = roleService.findByUser(user.getRoleId());
		userRoleDTO.setCanModify(role.getCanModify());
		userRoleDTO.setCanSee(role.getCanSee());
		userRoleDTO.setRoleName(role.getName());
		return userRoleDTO;
	}

	/**
	 * Retorna una lista de todos los registros de la entidad Users convertidos en UserRoleDTO.
	 * @return List<UserRoleDTO> lista de todos los registros de Users en UserRoleDTO.
	 */
	public List<UserRoleDTO> findAllUserRoleDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToUserRoleDto)
				.collect(Collectors.toList());
	}
	
	/**
	 * Busca el usuario del distribuidor de una cancion por su id y lo retorna de tipo BasicUserDTO.
	 * @param songId Long id de la cancion.
	 * @return BasicUserDTO usuario del distribuidor de la cancion.
	 */
	public BasicUserDTO findDistributorBasicUserDtoBySong(Long songId) {
		Product prod = productService.findBySong(songId);
		return castEntityToBasicUserDto(getReferenceById(prod.getDistributorId()));
	}
	
	/**
	 * Busca el usuario del distribuidor de un album por su id y lo retorna de tipo BasicUserDTO.
	 * @param albumId Long id del album.
	 * @return BasicUserDTO usuario del distribuidor del album.
	 */
	public BasicUserDTO findDistributorBasicUserDtoByAlbum(Long albumId) {
		Product prod = productService.findByAlbum(albumId);
		return castEntityToBasicUserDto(getReferenceById(prod.getDistributorId()));
	}
	
	/**
	 * Busca el usuario del distribuidor de un vinilo por su id y lo retorna de tipo BasicUserDTO.
	 * @param vinylId Long id del vinilo.
	 * @return BasicUserDTO usuario del distribuidor del vinilo.
	 */
	public BasicUserDTO findDistributorBasicUserDtoByVinyl(Long vinylId) {
		Product prod = productService.findByVinyl(vinylId);
		return castEntityToBasicUserDto(getReferenceById(prod.getDistributorId()));
	}

	@Override
	public Users findByEmail(String email) {
		return repository.findByEmail(email);
	}

	/**
	 * Obtiene un registro de la entidad Users y la retorna de tipo BasicUserDTO
	 * @param id Long id del usuario
	 * @return BasicUserDTO dto.
	 */
	public BasicUserDTO getReferenceBasicUserDtoById(Long id) {
		return castEntityToBasicUserDto(getReferenceById(id));
	}
	
	/**
	 * Convierte una instancia de la entidad Users al DTO de Consumer.
	 * @param ent Users instancia de la entidad Users
	 * @return ConsumerDTO instancia de ConsumerDTO
	 */
	public ConsumerDTO castEntityToConsumerDTO(Users ent) {
		ConsumerDTO dto = new ConsumerDTO();
		dto.setUserRole(castEntityToUserRoleDto(ent));
		dto.setApprovals(approvalService.findAllApprovalConsumerDtoByApplicant(ent.getId()));
		dto.setLibrary(libraryService.getLibraryDtoByConsumer(ent.getId()));
		dto.setDigitalOrders(ordersService.findAllDigitalOrderDtoByConsumer(ent.getId()));
		dto.setPhysicalOrders(ordersService.findAllPhysicalOrderDtoByConsumer(ent.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Users convertidos en ConsumerDTO.
	 * @return List<ConsumerDTO> lista de todos los registros de Users en ConsumerDTO.
	 */
	public List<ConsumerDTO> findAllConsumerDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToConsumerDTO)
				.collect(Collectors.toList());
	}
	
	/**
	 * Convierte una instancia de la entidad Users al DTO de Distributor.
	 * @param ent Users instancia de la entidad Users
	 * @return DistributorDTO instancia de DistributorDTO
	 */
	public DistributorDTO castEntityToDistributorDTO(Users ent) {
		DistributorDTO dto = new DistributorDTO();
		dto.setUserRole(castEntityToUserRoleDto(ent));
		dto.setApprovals(approvalService.findAllApprovalDistributorDtoByApplicant(ent.getId()));
		dto.setCatalogue(catalogueService.getCatalogueDtoByDistributor(ent.getId()));
		return dto;
	}
	
	/**
	 * Retorna una lista de todos los registros de la entidad Users convertidos en DistributorDTO.
	 * @return List<DistributorDTO> lista de todos los registros de Users en DistributorDTO.
	 */
	public List<DistributorDTO> findAllDistributorDto() {
		return repository.findAll()
				.stream()
				.map(this::castEntityToDistributorDTO)
				.collect(Collectors.toList());
	}
}
