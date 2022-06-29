package com.gestion.facturas.controlador;

import java.util.List;

import com.gestion.facturas.servicios.DetalleServices;
import com.gestion.facturas.modelo.Detalle;
import com.gestion.facturas.repositorio.DetalleRepositorio;

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
@RequestMapping("/api/detalles")
public class DetalleControlador {
	@Autowired
	private DetalleServices detalleServices;
	
	@Autowired
	DetalleRepositorio detalleRepo;

	@GetMapping("/listar") 
	public ResponseEntity<List<Detalle>> listarDetalles() {
		return new ResponseEntity<>(detalleServices.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/listarporparametros/{idFactura}")
	public ResponseEntity<List<Detalle>> listarDetallesPorFactura(@PathVariable Long idFactura) {
		System.out.println("idFactura " + idFactura);
		return new ResponseEntity<>(detalleRepo.findByFactura(idFactura), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Detalle> crearDetalles(@RequestBody Detalle detalle) {
		return new ResponseEntity<>(detalleServices.save(detalle), HttpStatus.CREATED);
	}
	

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Detalle> actualizarDetalles(@PathVariable Long id, @RequestBody Detalle detalle) {
		
		Detalle detalleEncontrado = detalleServices.findById(id);

		if (detalleEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {
			detalleEncontrado.setCantidad(detalle.getCantidad());
			detalleEncontrado.setPrecio(detalle.getPrecio());

			return new ResponseEntity<>(detalleServices.save(detalleEncontrado), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
 
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarFactura(@PathVariable Long id) {
		detalleServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
