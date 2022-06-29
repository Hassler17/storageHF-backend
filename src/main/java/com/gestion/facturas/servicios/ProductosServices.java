package com.gestion.facturas.servicios;

import java.util.List;

import com.gestion.facturas.modelo.Producto;

public interface ProductosServices {
	public Producto save(Producto producto);

	public Producto findById(Long id);

	public List<Producto> findAll();

	public void delete(Long id);
}
