package com.poli.songstock.service;

import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TestCatalogoSvc extends TestCase{
/*
	private CatalogoBusiness catalogoSvc = CatalogoBusiness.getInstance();
	
	@Test
	public void testCalcularTotalCarrito() {
		Double p1 = 10020.0;
		Double p2 = 20000.0;
		Double p3 = 45030.0;
		CancionDTO prod1 = new CancionDTO();
		prod1.setPrecio(p1);
		CancionDTO prod2 = new CancionDTO();
		prod2.setPrecio(p2);
		CancionDTO prod3 = new CancionDTO();
		prod3.setPrecio(p3);
		catalogoSvc.agregarProductoAlCarrito(prod1);
		catalogoSvc.agregarProductoAlCarrito(prod2);
		catalogoSvc.agregarProductoAlCarrito(prod3);
		assertEquals((p1+p2+p3), catalogoSvc.calcularTotalCarrito());
	}
	
	@Test
	public void testActualizarCancion () {
		catalogoSvc.registrarCancion(
				null, null, "Titulo 1 original", null, 12000.0, null,"1234", 0, 69
		);
		catalogoSvc.modificarCancion(
				null, null, "Titulo 1 modificado", null, 14000.0, null,"1234", 0, 43
		);
		CancionDTO filtro = new CancionDTO();
		filtro.setCodigo("1234");
		List<CancionDTO> cancs = catalogoSvc.getCancionesFiltradas(filtro);
		assertFalse("El codigo de la cancion no existe", cancs==null || cancs.isEmpty());
		assertTrue("Error en modificacion de nombre de cancion", cancs.get(0).getTitulo().equals("Titulo 1 modificado"));
	}
	*/
}
