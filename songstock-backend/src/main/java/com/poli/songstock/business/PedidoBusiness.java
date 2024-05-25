package com.poli.songstock.business;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.poli.songstock.controller.AprobacionController;
import com.poli.songstock.domain.AprobacionDTO;
import com.poli.songstock.domain.PedidoDTO;
import com.poli.songstock.domain.ProductoReproducibleDTO;

public class PedidoBusiness {
	
	private static PedidoBusiness instance;
	private AprobacionController rest = AprobacionController.getInstace();
	
	public static PedidoBusiness getInstance () {
		if(instance==null) {
			instance = new PedidoBusiness();
		}
		return instance;
	}

	/**
	 * Revisa si una aprobacion tiene como estado AprobacionDTO.ESTADO_APROBADO segun su codigo.
	 * @param codigo String codigo unico de la aprobacion
	 * @return true si el estado de la aprobacion segun su codigo es AprobacionDTO.ESTADO_APROBADO
	 * @throws Exception en caso que no exista una aprobacion con ese codigo.
	 */
	public boolean confirmarAprobacion(String codigo) throws Exception {
		AprobacionDTO aprobacion = aprobacionByCodigo(codigo);
		if(aprobacion==null) {
			throw new Exception("No se encontro la aprobacion con el codigo en PedidoSvc.estaAprobado");
		}
		
		return(aprobacion.getEstado().equals(AprobacionDTO.ESTADO_APROBADO));
	}
	
	/**
	 * Busca una aprobacion por su codigo.
	 * @param codigo String codigo unico de una aprobacion.
	 * @return AprobacionDTO aprobacion encontrada.
	 */
	public AprobacionDTO aprobacionByCodigo(String codigo) {
		ResponseEntity<AprobacionDTO> rta = rest.findByCodigoAprobacion(codigo);
		return rta.getBody();
	}

	/**
	 * Revisa si una aprobacion existe segun su codigo.
	 * @param codigo
	 * @return
	 */
	public boolean existsAprobacionByCodigo(String codigo) {
		ResponseEntity<AprobacionDTO> rta = rest.findByCodigoAprobacion(codigo);
		return(rta.getBody()!= null && rta.getBody().getCodigo().equals(codigo));
	}
	
	/**
	 * Crea una aprobacion recibiendo un codigo, descripcion y observacion.
	 * @param codigo
	 * @param descripcion
	 * @param obs
	 * @return true si se confirma que se creo la aprobacion.
	 */
	public boolean crearAprobacion (
			String descripcion,
			String obs,
			String codigo) {
		AprobacionDTO aprobacionDTO = new AprobacionDTO(
				descripcion,
				obs,
				codigo,
				new Date(),
				AprobacionDTO.ESTADO_PENDIENTE);
		ResponseEntity<AprobacionDTO> rta = rest.saveAprobacion(aprobacionDTO);
		if(rta.getStatusCode().is2xxSuccessful()) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public boolean eliminarAprobacion(String codigo) {
		return rest.deleteByCodigoAprobacion(codigo).getBody();
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
