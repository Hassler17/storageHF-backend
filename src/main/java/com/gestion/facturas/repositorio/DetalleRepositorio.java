package com.gestion.facturas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.gestion.facturas.modelo.Detalle;

@Repository
public interface DetalleRepositorio extends JpaRepository<Detalle, Long> {

	public List<Detalle> findByFactura(Long factura);
	
}
