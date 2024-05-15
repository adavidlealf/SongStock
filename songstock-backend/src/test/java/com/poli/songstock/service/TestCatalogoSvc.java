package com.poli.songstock.service;

import com.poli.songstock.model.CancionDTO;

import junit.framework.TestCase;

public class TestCatalogoSvc extends TestCase{

	private CatalogoSvc catalogoSvc = CatalogoSvc.getInstance();
	
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
}
