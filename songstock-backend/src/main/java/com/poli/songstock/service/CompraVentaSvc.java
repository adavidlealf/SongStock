package com.poli.songstock.service;

import java.util.Date;
import java.util.List;

import com.poli.songstock.model.AlbumDTO;
import com.poli.songstock.model.CancionDTO;
import com.poli.songstock.model.ProductoReproducibleDTO;

public class CompraVentaSvc {

	/**
	 * Agrega el producto reproducible al carrito de mercado.
	 * @param prod ProductoReproducibleDTO
	 */
	public void agregarProducto(ProductoReproducibleDTO prod) {
		
	}
	
	/**
	 * Crea un registro de AlbumDTO
	 * @param artistas List<String> nombres
	 * @param generos List<String> generos
	 * @param titulo String
	 * @param fechaLanzamiento Date
	 * @param precio Double
	 * @param formato String (Digital/Fisico)
	 * @param codigo String identificador
	 * @param numeroVentas Integer
	 * @param duracion Integer (rpm)
	 * @param urlPortada String
	 * @param canciones List<CancionDTO>
	 */
	public void registrarAlbum(List<String> artistas, List<String> generos,
			String titulo, Date fechaLanzamiento, Double precio, String formato, String codigo, 
			Integer numeroVentas, Integer duracion, String urlPortada, List<CancionDTO> canciones) {
		
	}
	
	/**
	 * Crear un registro de un vinilo.
	 * @param artistas
	 * @param generos
	 * @param titulo
	 * @param fechaLanzamiento
	 * @param precio
	 * @param formato
	 * @param codigo
	 * @param numeroVentas
	 * @param duracion
	 * @param urlPortada
	 * @param canciones
	 * @param color
	 * @param pulgadas
	 * @param condicion
	 * @param velocidad
	 * @param inventario
	 */
	public void registrarVinilo(List<String> artistas, List<String> generos,
			String titulo, Date fechaLanzamiento, Double precio, String formato, String codigo,
			Integer numeroVentas, Integer duracion, String urlPortada, List<CancionDTO> canciones,
			String color, Integer pulgadas, String condicion, Integer velocidad, Integer inventario) {
	}
	
	/**
	 * Crear un registro de un vinilo con instancia de album.
	 * @param album
	 * @param color
	 * @param pulgadas
	 * @param condicion
	 * @param velocidad
	 * @param inventario
	 */
	public void registrarVinilo(AlbumDTO album, String color, Integer pulgadas, 
			String condicion, Integer velocidad, Integer inventario) {
	}
	
	/**
	 * Modificar un registro de un vinilo.
	 * @param codigo
	 * @param artistas
	 * @param generos
	 * @param titulo
	 * @param fechaLanzamiento
	 * @param precio
	 * @param formato
	 * @param numeroVentas
	 * @param duracion
	 * @param urlPortada
	 * @param canciones
	 * @param color
	 * @param pulgadas
	 * @param condicion
	 * @param velocidad
	 * @param inventario
	 */
	public void actualizarVinilo(String codigo, List<String> artistas, List<String> generos,
			String titulo, Date fechaLanzamiento, Double precio, String formato, 
			Integer numeroVentas, Integer duracion, String urlPortada, List<CancionDTO> canciones,
			String color, Integer pulgadas, String condicion, Integer velocidad, Integer inventario) {
	}
	
	/**
	 * Modificar un registro de un vinilo con instancia de album.
	 * @param album
	 * @param color
	 * @param pulgadas
	 * @param condicion
	 * @param velocidad
	 * @param inventario
	 */
	public void actualizarVinilo(AlbumDTO album, String color, Integer pulgadas, 
			String condicion, Integer velocidad, Integer inventario) {
	}
	
	/*
	 * Eliminar un registro de un vinilo .
	 */
	public void eliminarVinilo(String codigoVinilo) {
	}
	
	
	/**
	 * Actualizar album
	 * @param codigo
	 * @param artistas
	 * @param generos
	 * @param titulo
	 * @param fechaLanzamiento
	 * @param precio
	 * @param formato
	 * @param numeroVentas
	 * @param duracion
	 * @param urlPortada
	 * @param canciones
	 * @param color
	 * @param pulgadas
	 * @param condicion
	 * @param velocidad
	 * @param inventario
	 */
	public void actualizarAlbum(String codigo, List<String> artistas, List<String> generos,
			String titulo, Date fechaLanzamiento, Double precio, String formato, 
			Integer numeroVentas, Integer duracion, String urlPortada, List<CancionDTO> canciones,
			String color, Integer pulgadas, String condicion, Integer velocidad, Integer inventario) {
	}
	
	/**
	 * Eliminar un album mediante su codigo.
	 * @param codigoAlbum
	 */
	public void eliminarAlbum(String codigoAlbum) {
	}
	
}
