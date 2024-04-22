package com.poli.songstock.service;

import java.util.Date;
import java.util.List;

import com.poli.songstock.model.AprobacionDTO;

public class AdministracionSvc {

	
	/**
	 * Crear un usuario de perfil proveedor.
	 * @param correo
	 * @param nombreUsuario
	 * @param password
	 * @param estado
	 * @param nombre
	 * @param fechaNacimiento
	 * @param paisOrigen
	 */
	public void registrarProveedor(String correo, String nombreUsuario, String password, 
			String estado, String nombre, Date fechaNacimiento, String paisOrigen) {
		
	}
	
	/**
	 * Obtiene el listado de aprobaciones que faltan por revisar.
	 * @return
	 */
	public List<AprobacionDTO> getAprobacionesPendientes(){
		return null;
	}
}
