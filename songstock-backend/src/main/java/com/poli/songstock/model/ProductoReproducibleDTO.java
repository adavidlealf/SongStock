package com.poli.songstock.model;

import java.util.Date;
import java.util.List;

public abstract class ProductoReproducibleDTO {

	/*
	 * Lista de nombres de artistas 
	 */
	private List<String> artistas;
	/*
	 * Lista de nombres de generos
	 */
	private List<String> generos;
	/*
	 * Titulo del producto 
	 */
	private String titulo;
	/*
	 * Fecha de Lanzamiento del producto
	 */
	private	Date fechaLanzamiento;
	/*
	 * Precio del producto
	 */
	private	Double precio;
	/*
	 * Formato del producto (Digital/Fisico)
	 */
	private	String formato;
	/*
	 * Numero de ventas del producto
	 */
	private	Integer numeroVentas;
	/*
	 * Duracion en segundos del producto
	 */
	private	Integer duracion;
	/*
	 * Url de la imagen del producto
	 */
	private String urlImage;
	/**
	 * @return the artistas
	 */
	public List<String> getArtistas() {
		return artistas;
	}
	/**
	 * @param artistas the artistas to set
	 */
	public void setArtistas(List<String> artistas) {
		this.artistas = artistas;
	}
	/**
	 * @return the generos
	 */
	public List<String> getGeneros() {
		return generos;
	}
	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(List<String> generos) {
		this.generos = generos;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the fechaLanzamiento
	 */
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	/**
	 * @param fechaLanzamiento the fechaLanzamiento to set
	 */
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	/**
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}
	/**
	 * @param formato the formato to set
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}
	/**
	 * @return the numeroVentas
	 */
	public Integer getNumeroVentas() {
		return numeroVentas;
	}
	/**
	 * @param numeroVentas the numeroVentas to set
	 */
	public void setNumeroVentas(Integer numeroVentas) {
		this.numeroVentas = numeroVentas;
	}
	/**
	 * @return the duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}
	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
}
