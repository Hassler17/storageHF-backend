package com.gestion.facturas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion.facturas.modelo.Producto;
import com.gestion.facturas.repositorio.ProductoRepositorio;

@Service
public class ProductosServicesImpl implements ProductosServices {

	@Autowired
	private ProductoRepositorio productoDao;

	@Override
	public Producto save(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public List<Producto> findAll() {
		return productoDao.findAll();
	}

	@Override
	public void delete(Long id) {
		productoDao.deleteById(id);
	}

}
