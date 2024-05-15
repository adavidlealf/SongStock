package com.poli.songstock.service;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import com.poli.songstock.model.AprobacionDTO;

public class TestPedidoSvc extends TestCase{
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
    }
}
