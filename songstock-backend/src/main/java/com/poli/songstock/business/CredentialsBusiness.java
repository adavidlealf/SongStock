package com.poli.songstock.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poli.songstock.domain.Role;
import com.poli.songstock.dto.UserDTO;
import com.poli.songstock.service.RoleService;

@Component
public class CredentialsBusiness {
	
	@Autowired
	private RoleService roleService;
	
	/*
	 * REQUIREMENT 1
	 * */

	public Object registerUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
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
	private Boolean createRole(Role.Name name, String canSee, String canModify) {
		Role role = new Role();
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
			Boolean b = createRole(Role.Name.ADMINISTRATOR, "*", "*");
			b &= createRole(Role.Name.CONSUMER, null, null);
			b &= createRole(Role.Name.DISTRIBUTOR, null, null);
		}
		return roleService.count()==3;
	}

}
