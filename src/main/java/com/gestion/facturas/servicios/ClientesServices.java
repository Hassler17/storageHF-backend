package com.gestion.facturas.servicios;

import java.util.List;

import com.gestion.facturas.modelo.Cliente;

public interface ClientesServices {
	public Cliente save(Cliente cliente);

	public Cliente findById(Long id);

	public List<Cliente> findAll();

	public void delete(Long id);
}
