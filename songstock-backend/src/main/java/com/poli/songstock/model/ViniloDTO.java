package com.poli.songstock.model;

public class ViniloDTO {

	/*
	 * Album relacionado al vinilo.
	 */
	AlbumDTO album;
	/*
	 * Codigo hexadecimal del color del vinilo.
	 */
	String color;
	/*
	 * Numero de pulgadas del vinilo.
	 */
	Integer pulgadas;
	/*
	 * Breve descripcion del estado del vinilo (nuevo, usado).
	 */
	String condicion;
	/*
	 * Velocidad del vinilo en rpm
	 */
	Integer velocidad;
	/*
	 * Url de la imagen del vinilo.
	 */
	String urlImagen;
	/*
	 * Cantidad de ejemplares del vinilo.
	 */
	Integer inventario;
	/*
	 * Codigo identificador del vinilo.
	 */
	String codigo;
	
}
