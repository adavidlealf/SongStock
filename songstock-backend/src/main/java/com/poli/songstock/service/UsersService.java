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

import com.poli.songstock.domain.Role;
import com.poli.songstock.domain.Users;
import com.poli.songstock.dto.BasicUserDTO;
import com.poli.songstock.dto.UserDTO;
import com.poli.songstock.dto.UserRoleDTO;
import com.poli.songstock.repository.UsersRepository;

@Service
public class UsersService implements UsersRepository{
	
	@Autowired
	private UsersRepository repository;
	
	/**
	 * Patron Singleton.
	 */
	private static UsersService instance;
	
	/**
	 * Obtener instancia de patron singleton.
	 * @return
	 */
	public static UsersService getInstance() {
		if(instance == null) {
			instance = new UsersService();
		}
		return instance;
	}
	
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		userDTO.setAddresses(AddressService.getInstance()
				.findAllAddressDtoByUser(user.getId()));
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
		Role role = RoleService.getInstance().findByUser(user.getRoleId());
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

	@Override
	public Users findDistributorByVinyl(Long distributorId) {
		return repository.findDistributorByVinyl(distributorId);
	}
	
	/**
	 * Busca un usuario distribuidor que tiene un vinilo y lo retorna en un BasicUserDTO.
	 * @param distributorId Long id del distribuidor del vinilo.
	 * @return BasicUserDTO instancia del distribuidor.
	 */
	public BasicUserDTO findDistributorBasicUserDtoByVinyl(Long distributorId) {
		return castEntityToBasicUserDto(findDistributorByVinyl(distributorId));
	}
}
