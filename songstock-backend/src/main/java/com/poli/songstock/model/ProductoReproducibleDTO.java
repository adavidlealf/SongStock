package com.poli.songstock.model;

import java.util.Date;
import java.util.List;

public abstract class ProductoReproducibleDTO {

	/*
	 * Lista de nombres de artistas 
	 */
	List<String> artistas;
	/*
	 * Lista de nombres de generos
	 */
	List<String> generos;
	/*
	 * Titulo del producto 
	 */
	String titulo;
	/*
	 * Fecha de Lanzamiento del producto
	 */
	Date fechaLanzamiento;
	/*
	 * Precio del producto
	 */
	Double precio;
	/*
	 * Formato del producto (Digital/Fisico)
	 */
	String formato;
	/*
	 * Numero de ventas del producto
	 */
	Integer numeroVentas;
	/*
	 * Duracion en segundos del producto
	 */
	Integer duracion;
	/*
	 * Url de la imagen del producto
	 */
	String urlImage;
	/**
	 * @return the artistas
	 */
	private List<String> getArtistas() {
		return artistas;
	}
	/**
	 * @param artistas the artistas to set
	 */
	private void setArtistas(List<String> artistas) {
		this.artistas = artistas;
	}
	/**
	 * @return the generos
	 */
	private List<String> getGeneros() {
		return generos;
	}
	/**
	 * @param generos the generos to set
	 */
	private void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	/**
	 * @return the titulo
	 */
	private String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the fechaLanzamiento
	 */
	private Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	/**
	 * @param fechaLanzamiento the fechaLanzamiento to set
	 */
	private void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	/**
	 * @return the precio
	 */
	private Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	private void setPrecio(Double precio) {
		this.precio = precio;
	}
	/**
	 * @return the formato
	 */
	private String getFormato() {
		return formato;
	}
	/**
	 * @param formato the formato to set
	 */
	private void setFormato(String formato) {
		this.formato = formato;
	}
	/**
	 * @return the numeroVentas
	 */
	private Integer getNumeroVentas() {
		return numeroVentas;
	}
	/**
	 * @param numeroVentas the numeroVentas to set
	 */
	private void setNumeroVentas(Integer numeroVentas) {
		this.numeroVentas = numeroVentas;
	}
	/**
	 * @return the duracion
	 */
	private Integer getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	private void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the urlImage
	 */
	private String getUrlImage() {
		return urlImage;
	}
	/**
	 * @param urlImage the urlImage to set
	 */
	private void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
}
