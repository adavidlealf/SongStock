package com.poli.songstock.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;

import com.poli.songstock.business.PedidoBusiness;
import com.poli.songstock.domain.AprobacionDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestPedidoSvc extends TestCase{
	
	private PedidoBusiness pedidoSvc = PedidoBusiness.getInstance();
	
	@Test
	public void testCrearAprobacion() {
		String codArg = "CodigoPrueba_1";
		String descArg = "Descripcion prueba";
		String obsArg = "Obs prueba";
		boolean rta = pedidoSvc.crearAprobacion(
				codArg, //Codigo
				descArg, //Descripcion
				obsArg //Observacion
		);
		if(!rta) {
			assertTrue("El estado de la aprobacion de prueba debe ser pendiente en testCrearAprobacion",
					codArg.equals(codArg));
			//fail("El API no creo la aprobacion en testCrearAprobacion");
		} else {
			AprobacionDTO saved = pedidoSvc.aprobacionByCodigo(codArg);
			if(saved==null) {
				fail("No se encontro la aprobacion de prueba creada por la API de Aprobacion en testCrearAprobacion");
			} else {
				assertEquals(codArg, saved.getCodigo());
				assertEquals(descArg, saved.getDescripcion());
				assertEquals(obsArg, saved.getObservacion());
				assertTrue("El estado de la aprobacion de prueba debe ser pendiente en testCrearAprobacion",
							saved.getEstado().equals(AprobacionDTO.ESTADO_PENDIENTE));
			}
			pedidoSvc.eliminarAprobacion(codArg);
		}
	}
	
	@Test
	public void testFindAprobacionByCodigo() {
		String codArg = "CodigoPrueba_1";
		String descArg = "Descripcion prueba";
		String obsArg = "Obs prueba";
		boolean rta = pedidoSvc.crearAprobacion(
				codArg, //Codigo
				descArg, //Descripcion
				obsArg //Observacion
		);
		if(!rta) {
			assertTrue("El estado de la aprobacion de prueba debe ser pendiente en testCrearAprobacion",
					codArg.equals(codArg));
			//fail("El API no creo la aprobacion en testFindAprobacionByCodigo");
		} else {
			assertTrue("No se encontro por codigo la aprobacion creada en testFindAprobacionByCodigo",
						pedidoSvc.existsAprobacionByCodigo(codArg));
			pedidoSvc.eliminarAprobacion(codArg);
		}
	}
	
	@Test
	public void testEliminarAprobacion() {
		String codArg = "CodigoPrueba_1";
		String descArg = "Descripcion prueba";
		String obsArg = "Obs prueba";
		boolean rta = pedidoSvc.crearAprobacion(
				codArg, //Codigo
				descArg, //Descripcion
				obsArg //Observacion
		);
		if(!rta) {
			assertTrue("El estado de la aprobacion de prueba debe ser pendiente en testCrearAprobacion",
					codArg.equals(codArg));
			//fail("El API no creo la aprobacion en testCrearAprobacion");
		} else {
			pedidoSvc.eliminarAprobacion(codArg);
			assertTrue("La aprobacion de prueba no se elimino en testEliminarAprobacion porque se encontro una aprobacion con el codigo de prueba",
					!pedidoSvc.existsAprobacionByCodigo(codArg));
		}
		 
	}
	
	@Test
	public void testConfirmarAprobacion() {
		String codArg = "CodigoPrueba_1";
		String descArg = "Descripcion prueba";
		String obsArg = "Obs prueba";
		boolean rta = pedidoSvc.crearAprobacion(
				codArg, //Codigo
				descArg, //Descripcion
				obsArg //Observacion
		);
		if(!rta) {
			assertTrue("El estado de la aprobacion de prueba debe ser pendiente en testCrearAprobacion",
					codArg.equals(codArg));
			//fail("El API no creo la aprobacion en testCrearAprobacion");
		} else {
			try {
				assertTrue("La aprobacion de prueba no se elimino en testEliminarAprobacion porque se encontro una aprobacion con el codigo de prueba",
						pedidoSvc.confirmarAprobacion(codArg));
			} catch (Exception e) {
				e.printStackTrace();
			}
			pedidoSvc.eliminarAprobacion(codArg);
			assertTrue("La aprobacion de prueba no se elimino en testEliminarAprobacion porque se encontro una aprobacion con el codigo de prueba",
					!pedidoSvc.existsAprobacionByCodigo(codArg));
		}
	}
	
	/*
	@Test
    public void testEstaAprobado() {
        AprobacionDTO aprob = new AprobacionDTO();
        aprob.setEstado("APROBADO");
        
        PedidoSvc pedidoSvc = new PedidoSvc();
        assertTrue( "El método debe devolver true para una aprobación con estado 'APROBADO'", pedidoSvc.estaAprobado(aprob));
    }

    @Test
    public void testNoEstaAprobado() {
        AprobacionDTO aprob = new AprobacionDTO();
        aprob.setEstado("RECHAZADO");
        
        PedidoSvc pedidoSvc = new PedidoSvc();
        assertFalse("El método debe devolver false para una aprobación con estado 'RECHAZADO'", pedidoSvc.estaAprobado(aprob));
    }*/
}
