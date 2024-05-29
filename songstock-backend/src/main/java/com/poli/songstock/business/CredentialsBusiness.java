package com.poli.songstock.business;

import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poli.songstock.domain.Role;
import com.poli.songstock.domain.Users;
import com.poli.songstock.dto.UserDTO;
import com.poli.songstock.service.RoleService;
import com.poli.songstock.service.UsersService;

@Component
public class CredentialsBusiness {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UsersService usersService;
	

	/**
	 * Registra un usuario con su respectivo rol.
	 * @param nickName String arroba (debe ser unico)
	 * @param name String nombre 
	 * @param email String correo (debe ser unico)
	 * @param password String clave
	 * @param birthdate Date fecha de nacimiento
	 * @param roleId Long id del rol, este debe existir o arrojara excepcion
	 * @return Boolean true si se guarda satisfactoriamente el usuario.
	 * @throws Exception en caso de no encontrar el rol con el id
	 */
	public Boolean registerUser(
			String nickName
			, String name
			, String email
			, String password
			, Date birthdate
			, Long roleId
		) throws Exception {
		Users entity = new Users();
		entity.setNickname(nickName);
		entity.setName(name);
		entity.setEmail(email);
		entity.setPassword(password);
		entity.setBirthdate(birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		if(roleService.existsById(roleId)) {
			entity.setRoleId(roleId);
		} else {
			throw new Exception("No existe rol con id "+roleId);
		}
		entity = usersService.save(entity);
		return (!LogicBusiness.isEmpty(entity) && !LogicBusiness.isEmpty(entity.getId()));
	}
	
	public Object loginUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
     * REQUIREMENT 8
     */
	
	public Object registerProvider(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Crea un rol dado su enum nombre, su lista de palabras concatenadas por coma 
	 * que puede ver, y su lista de palabras concatenadas por coma que puede modificar.
	 * @param name Role.Name enum de nombre de rol (solo hay 3 opciones)
	 * @param canSee String lista de palabras concatenadas por coma que puede ver
	 * @param canModify String lista de palabras concatenadas por coma que puede modificar
	 * @return Boolean true si la creacion fue exitosa.
	 */
	private Boolean createRole(
			Role.Name name
			, String canSee
			, String canModify
			, Long id
		) {
		Role role = new Role();
		role.setId(id);
		role.setName(name);
		role.setCanSee(canSee);
		role.setCanModify(canModify);
		role = roleService.save(role);
		return (!LogicBusiness.isEmpty(role) && !LogicBusiness.isEmpty(role.getId()));
	}
	
	/**
	 * Crea los unicos 3 roles que deben existir por defecto, administrador, consumidor, 
	 * y distribuidor.
	 * @return Boolean true si todos los roles se crearon o si no se tuvo que crear ninguno, 
	 * false si hubo algun error. 
	 */
	public Boolean createDefaultRoles() {
		if(roleService.count()!=3) {
			roleService.deleteAll();
			Boolean b = createRole(Role.Name.ADMINISTRATOR, "*", "*", 1L);
			b &= createRole(Role.Name.CONSUMER, null, null, 2L);
			b &= createRole(Role.Name.DISTRIBUTOR, null, null, 3L);
		}
		return roleService.count()==3;
	}

}
