package com.gestion.facturas.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.facturas.modelo.Cliente;
import com.gestion.facturas.repositorio.ClienteRepositorio;

@Service
public class ClientesServicesImpl implements ClientesServices {

	
	@Autowired
	private ClienteRepositorio clienteDao;
	
	
	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> findAll() {
		return clienteDao.findAll();
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

}
