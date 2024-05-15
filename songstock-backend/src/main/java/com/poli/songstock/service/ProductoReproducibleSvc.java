package com.poli.songstock.service;

import java.util.List;

import com.poli.songstock.model.ProductoReproducibleDTO;

public class ProductoReproducibleSvc {
	
	private static ProductoReproducibleSvc instance;
	
	/**
	 * Metodo que implementa patron Singleton.
	 * @return
	 */
	public static ProductoReproducibleSvc getInstance() {
		if(instance==null) {
			instance = new ProductoReproducibleSvc();
		}
		return instance;
	}

	/**
	 * Busca si hay inventario del producto en formato fisico, o si se puede
	 * comprar en formato digital. En cualquier caso, retorna la lista de 
	 * tipos de ProductoReproducible que esten a la venta.
	 * @param prod ProductoReproducibleDTO instancia del producto del catalogo
	 * a buscar opciones de compra.
	 * @return List<ProductoReproducibleDTO> opciones de compra.
	 */
	public List<ProductoReproducibleDTO> opcionesCompra(ProductoReproducibleDTO prod){
		return null;
	}
	
	/**
	 * Revisa si el producto esta disponible a la venta, y cuenta con el stock suficiente. 
	 * @param prod ProductoReproducibleDTO
	 * @return true en caso que el stock sea mayor o igual a la demanda.
	 */
	public boolean tieneStock(ProductoReproducibleDTO prod, int demanda) {
		return false;
	}
}
