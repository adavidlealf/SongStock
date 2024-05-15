package com.poli.songstock.service;

import org.junit.jupiter.api.Test;

import com.poli.songstock.model.ProductoReproducibleDTO;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

class TestProductoReproducibleSvc extends TestCase{

    private ProductoReproducibleSvc servicio = ProductoReproducibleSvc.getInstance();
    private ProductoReproducibleDTO producto = new ProductoReproducibleDTO();
    
    @Test
    void pruebaOpcionesCompra() {
        List<ProductoReproducibleDTO> resultado = servicio.opcionesCompra(producto);
        assertNotNull("La lista de opciones de compra no debe ser nula", resultado);
        assertFalse("La lista de opciones de compra no debe estar vacía", resultado.isEmpty());
    }

    @Test
    void pruebaTieneStock() {
        boolean resultado = servicio.tieneStock(producto.getStock, 5);
        assertTrue("Debe haber stock suficiente para la demanda",resultado);
    }
}