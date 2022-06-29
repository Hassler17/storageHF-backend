package com.gestion.facturas.servicios;

import java.util.List;
import com.gestion.facturas.modelo.Detalle;

public interface DetalleServices {
	public Detalle save(Detalle detalle);

	public List<Detalle> findAll();

	public Detalle findById(Long id);

	public void delete(Long id);

}
