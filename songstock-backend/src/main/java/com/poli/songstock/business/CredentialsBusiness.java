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
	 * @throws Exception en caso de no encontrar el rol con el id o si la password esta vacia.
	 */
	private Boolean registerUser(
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
		if(!LogicBusiness.isValidEmail(email)) {
			throw new Exception("El correo no cumple con el formato.");
		}
		entity.setEmail(email);
		if(LogicBusiness.isEmpty(password)) {
			throw new Exception("La password no debe ser vacia.");
		}
		entity.setPassword(password);
		if(birthdate!=null) {
			entity.setBirthdate(birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		if(roleService.existsById(roleId)) {
			entity.setRoleId(roleId);
		} else {
			throw new Exception("No existe rol con id "+roleId);
		}
		entity = usersService.save(entity);
		return (!LogicBusiness.isEmpty(entity) && !LogicBusiness.isEmpty(entity.getId()));
	}
	
	/**
	 * Revisa si una pareja email-password esta en la base de datos.
	 * @param email Strin correo
	 * @param password String clave
	 * @return true en caso de que la clave y el correo se cumplan.
	 */
	public Boolean loginUser(
			String email
			, String password
		) {
		Users u = usersService.findByEmail(email);
		return (!(
				LogicBusiness.isEmpty(u) 
				|| LogicBusiness.isEmpty(u.getId())
				|| (!u.getPassword().equals(password)))
			);
	}
	
	/**
	 * Registra un distribuidor de acuerdo a su informacion basica.
	 * @param nickName String arroba (debe ser unico)
	 * @param name String nombre 
	 * @param email String correo (debe ser unico)
	 * @param password String clave
	 * @param birthdate Date fecha de nacimiento
	 * @return Boolean true si se guarda satisfactoriamente el usuario.
	 * @throws Exception en caso de no encontrar el rol con el id o si la password esta vacia.
	 */
	public Boolean registerDistributor(
			String nickName
			, String name
			, String email
			, String password
			, Date birthdate
			) throws Exception {
		return registerUser(nickName, name, email, password, birthdate, 3L);
	}
	
	/**
	 * Registra un consumidor de acuerdo a su informacion basica.
	 * @param nickName String arroba (debe ser unico)
	 * @param name String nombre 
	 * @param email String correo (debe ser unico)
	 * @param password String clave
	 * @param birthdate Date fecha de nacimiento
	 * @return Boolean true si se guarda satisfactoriamente el usuario.
	 * @throws Exception en caso de no encontrar el rol con el id o si la password esta vacia.
	 */
	public Boolean registerConsumer(
			String nickName
			, String name
			, String email
			, String password
			, Date birthdate
			) throws Exception {
		return registerUser(nickName, name, email, password, birthdate, 2L);
	}
	
	/**
	 * Registra un consumidor de acuerdo a su informacion basica.
	 * @param nickName String arroba (debe ser unico)
	 * @param name String nombre 
	 * @param email String correo (debe ser unico)
	 * @param password String clave
	 * @param birthdate Date fecha de nacimiento
	 * @return Boolean true si se guarda satisfactoriamente el usuario o si ya estaba creado.
	 * @throws Exception en caso de no encontrar el rol con el id o si la password esta vacia.
	 */
	public Boolean registerAdmin(
			String email
			, String password
			) throws Exception {
		Users u = usersService.findByEmail(email);
		if(!LogicBusiness.isEmpty(u) 
				&& !LogicBusiness.isEmpty(u.getId())
			&& !u.getRoleId().equals(1L)) {
			return false;
		} else if(LogicBusiness.isEmpty(u) || LogicBusiness.isEmpty(u.getId())) {
			return registerUser("ADMIN", null, email, password, null, 1L);
		} return true;
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
