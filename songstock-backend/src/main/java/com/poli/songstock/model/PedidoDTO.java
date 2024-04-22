package com.poli.songstock.model;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
	Integer id;
	Date fecha;
	List<ProductoReproducibleDTO> productos;
	String estado;
	AprobacionDTO aprobacion;
	String direccionDest;
	String direccionRemitente;
	Date fechaEntrega;
	String ciudadDest;
	String ciudadRemitente;
	
}
