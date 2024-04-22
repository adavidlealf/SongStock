package com.poli.songstock.service;

import java.util.Date;
import java.util.List;

import com.poli.songstock.model.AprobacionDTO;
import com.poli.songstock.model.PedidoDTO;
import com.poli.songstock.model.ProductoReproducibleDTO;

public class PedidoSvc {

	/**
	 * Revisa el estado de una aprobacion
	 * @param aprob
	 * @return
	 */
	public boolean estaAprobado(AprobacionDTO aprob) {
		return false;
	}
	
	/**
	 * Crea un registro de aprobacion
	 * @param descripcion
	 * @param obs
	 * @param fechaSolicitud
	 * @param estado
	 */
	public void crearAprobacion(String descripcion, String obs, Date fechaSolicitud, String estado) {
		
	}
	
	/**
	 * Crear un pedido. Genera de manera automatica el id, la fecha, el estado, la aprobacion, y la fecha de entrega.
	 * @param prods
	 * @param direcDest
	 * @param direcRemitente
	 * @param ciudadDest
	 * @param ciudadRemitente
	 */
	public void crearPedido(List<ProductoReproducibleDTO> prods, String direcDest, 
			String direcRemitente, String ciudadDest, String ciudadRemitente) {
		
	}
	
	/**
	 * Genera el numero de guia de un pedido creado
	 * @param ped
	 */
	public String generarGuiaPedido(PedidoDTO ped) {
		return null;
	}
	
	/**
	 * Cambia el estado del pedido a enviado
	 * @param ped
	 */
	public void enviarPedido(PedidoDTO ped) {
		
	}
	
}
