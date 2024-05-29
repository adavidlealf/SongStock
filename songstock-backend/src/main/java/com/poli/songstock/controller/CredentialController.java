package com.poli.songstock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poli.songstock.business.CredentialsBusiness;
import com.poli.songstock.dto.BasicUserDTO;
import com.poli.songstock.dto.ConsumerDTO;
import com.poli.songstock.dto.DistributorDTO;
import com.poli.songstock.dto.UserDTO;
import com.poli.songstock.dto.UserRoleDTO;
import com.poli.songstock.requestbody.credential.LoginRequest;
import com.poli.songstock.requestbody.credential.RegisterUserRequest;

@RestController
@RequestMapping("/credential")
public class CredentialController {
	
	@Autowired
    private CredentialsBusiness credentialsBusiness;
	
	/**
	 * REST para revisar si la password es correcta segun un email.
	 * @param request LoginRequest estructura JSON con email y password.
	 * @return Boolean true en caso de ser correcta la password.
	 */
	@GetMapping(value = "/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody LoginRequest request) {
		try {
			boolean b = credentialsBusiness.loginUser(
					request.getEmail(), request.getPassword());
			return ResponseEntity.ok(b);
		} catch (Exception e) {
			System.out.println("----- Error en /login");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * REST para revisar si un correo ya tiene un usuario registrado.
	 * @param request LoginRequest estructura JSON con email y password.
	 * @return Boolean true en caso de ser correcta la password.
	 */
	@GetMapping(value = "/exists_by_email/{email}")
	public ResponseEntity<Boolean> loginUser(@PathVariable("email") String email) {
		try {
			boolean b = credentialsBusiness.existsUserByEmail(email);
			return ResponseEntity.ok(b);
		} catch (Exception e) {
			System.out.println("----- Error en /exists_by_email");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el BasicUserDTO de un usuario mediante su nickName
	 * @param nickName String arroba
	 * @return BasicUserDTO informacion del usuario.
	 */
	@GetMapping(value = "/basic/{nickname}")
	public ResponseEntity<BasicUserDTO> getBasicUserByNick(@PathVariable("nickname") String nickname) {
		try {
			BasicUserDTO dto = credentialsBusiness.getBasicUserByNick(nickname);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /basic/{nickname}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el UserDTO de un usuario mediante su nickName
	 * @param nickName String arroba
	 * @return UserDTO informacion del usuario.
	 */
	@GetMapping(value = "/normal/{nickname}")
	public ResponseEntity<UserDTO> getUserByNick(@PathVariable("nickname") String nickname) {
		try {
			UserDTO dto = credentialsBusiness.getUserByNick(nickname);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /normal/{nickname}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el UserRoleDTO de un usuario mediante su nickName
	 * @param nickName String arroba
	 * @return UserRoleDTO informacion del usuario.
	 */
	@GetMapping(value = "/role/{nickname}")
	public ResponseEntity<UserRoleDTO> getUserRoleByNick(@PathVariable("nickname") String nickname) {
		try {
			UserRoleDTO dto = credentialsBusiness.getUserRoleByNick(nickname);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /role/{nickname}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el ConsumerDTO de un usuario mediante su nickName
	 * @param nickName String arroba
	 * @return ConsumerDTO informacion del usuario.
	 */
	@GetMapping(value = "/consumer/{nickname}")
	public ResponseEntity<ConsumerDTO> getConsumerByNick(@PathVariable("nickname") String nickname) {
		try {
			ConsumerDTO dto = credentialsBusiness.getConsumerByNick(nickname);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /consumer/{nickname}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Obtiene el DistributorDTO de un usuario mediante su nickName
	 * @param nickName String arroba
	 * @return DistributorDTO informacion del usuario.
	 */
	@GetMapping(value = "/distributor/{nickname}")
	public ResponseEntity<DistributorDTO> getDistributorByNick(@PathVariable("nickname") String nickname) {
		try {
			DistributorDTO dto = credentialsBusiness.getDistributorByNick(nickname);
			if(dto != null) {
				return ResponseEntity.ok(dto);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /distributor/{nickname}");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	/**
	 * Crea un distribuidor en la base de datos.
	 * @param request RegisterUserRequest estructura JSON con nickName, name, email, password, birthdate.
	 * @return DistributorDTO instancia creada.
	 */
	@PostMapping("/distributor")
    public ResponseEntity<DistributorDTO> registerDistributor(@RequestBody RegisterUserRequest request) {
		try {
			Boolean b = credentialsBusiness.registerDistributor(
					request.getNickName()
					, request.getName()
					, request.getEmail()
					, request.getPassword()
					, request.getBirthdate()
				);
			if(b) {
				return ResponseEntity.ok(credentialsBusiness.getDistributorByNick(request.getNickName()));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /distributor");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
	
	/**
	 * Crea un consumidor en la base de datos.
	 * @param request RegisterUserRequest estructura JSON con nickName, name, email, password, birthdate.
	 * @return ConsumerDTO instancia creada.
	 */
	@PostMapping("/consumer")
    public ResponseEntity<ConsumerDTO> registerConsumer(@RequestBody RegisterUserRequest request) {
		try {
			Boolean b = credentialsBusiness.registerConsumer(
					request.getNickName()
					, request.getName()
					, request.getEmail()
					, request.getPassword()
					, request.getBirthdate()
				);
			if(b) {
				return ResponseEntity.ok(credentialsBusiness.getConsumerByNick(request.getNickName()));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		} catch (Exception e) {
			System.out.println("----- Error en /consumer");
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
	
}
