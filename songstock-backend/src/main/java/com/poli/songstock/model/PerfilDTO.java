package com.poli.songstock.model;

import java.util.Date;
import java.util.List;

public abstract class PerfilDTO {

	String correo;
	String nombreUsuario;
	String password;
	String estado;
	String nombre;
	Date fechaNacimiento;
	String paisOrigen;
	List<CatalogoDTO> catalogos;
	
	
}
