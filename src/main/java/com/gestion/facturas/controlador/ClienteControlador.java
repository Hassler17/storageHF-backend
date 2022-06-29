package com.gestion.facturas.controlador;

import java.util.List;

import com.gestion.facturas.servicios.ClientesServices;
import com.gestion.facturas.modelo.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {
	@Autowired
	private ClientesServices clientesServices;

	@GetMapping("/listar")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return new ResponseEntity<>(clientesServices.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id_cliente}")
	public ResponseEntity<Cliente> obtenerFactura(@PathVariable Long id_cliente) {
		return new ResponseEntity<>(clientesServices.findById(id_cliente), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Cliente> crearClientes(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clientesServices.save(cliente), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Cliente> actualizarClientes(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente clienteEncontrado = clientesServices.findById(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {

			clienteEncontrado.setNombre(cliente.getNombre());
			clienteEncontrado.setApellido(cliente.getApellido());
			clienteEncontrado.setDireccion(cliente.getDireccion());
			clienteEncontrado.setTelefono(cliente.getTelefono());
			clienteEncontrado.setEmail(cliente.getEmail());
			clienteEncontrado.setFecha_nacimiento(cliente.getFecha_nacimiento());

			return new ResponseEntity<>(clientesServices.save(clienteEncontrado), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarClientes(@PathVariable Long id) {
		clientesServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
