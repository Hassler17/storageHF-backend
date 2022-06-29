package com.gestion.facturas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.facturas.modelo.Detalle;
import com.gestion.facturas.repositorio.DetalleRepositorio;

@Service
public class DetalleServicesImpl implements DetalleServices {

	@Autowired
	private DetalleRepositorio detalleDao;

	@Override
	public Detalle save(Detalle detalle) {
		return detalleDao.save(detalle);
	}

	@Override
	public List<Detalle> findAll() {
		return detalleDao.findAll();
	}

	@Override
	public Detalle findById(Long id) {
		return detalleDao.findById(id).orElse(null);
	}
	@Override
	public void delete(Long id) {
		detalleDao.deleteById(id);

	}


}
