package com.gestion.facturas.controlador;

import java.util.List;

import com.gestion.facturas.servicios.FacturasServices;
//import com.gestion.facturas.DTO.facturasDTO;
import com.gestion.facturas.modelo.Factura;
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
@RequestMapping("/api/facturas")
public class FacturaControlador {
	@Autowired
	private FacturasServices facturasServices;

	@GetMapping("/listar")
	public ResponseEntity<List<Factura>> listarFacturas() {
		return new ResponseEntity<>(facturasServices.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{num_factura}")
	public ResponseEntity<Factura> obtenerFactura(@PathVariable Long num_factura) {
		return new ResponseEntity<>(facturasServices.findById(num_factura), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Factura> crearFactura(@RequestBody Factura factura) {
		return new ResponseEntity<>(facturasServices.save(factura), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura factura) {
		Factura facturaEncontrada = facturasServices.findById(id);

		if (facturaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {

			facturaEncontrada.setFecha(factura.getFecha());
			facturaEncontrada.setCliente(factura.getCliente());
			return new ResponseEntity<>(facturasServices.save(facturaEncontrada), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarFactura(@PathVariable Long id) {
		facturasServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
