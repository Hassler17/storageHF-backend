package com.gestion.facturas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.facturas.modelo.Factura;
import com.gestion.facturas.repositorio.FacturaRepositorio;

@Service
public class FacturaServicesImpl implements FacturasServices {

	@Autowired
	private FacturaRepositorio facturaDao;

	@Override
	public Factura save(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	public Factura findById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	public List<Factura> findAll() {
		return facturaDao.findAll();
	}

	@Override
	public void delete(Long id) {
		facturaDao.deleteById(id);

	}

}
