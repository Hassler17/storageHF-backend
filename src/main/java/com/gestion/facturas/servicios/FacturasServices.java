package com.gestion.facturas.servicios;

import java.util.List;

import com.gestion.facturas.modelo.Factura;

public interface FacturasServices {

	public Factura save(Factura factura);

	public Factura findById(Long id);

	public List<Factura> findAll();

	public void delete(Long id);
}
