package com.gestion.facturas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gestion.facturas.modelo.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Long> {

}
