package com.poli.songstock.model;

import java.util.List;

public class AlbumDTO extends ProductoReproducibleDTO{

	/*
	 * Canciones del album 
	 */
	List<CancionDTO> canciones;
	/*
	 * Codigo identificador del album.
	 */
	String codigo;
}
