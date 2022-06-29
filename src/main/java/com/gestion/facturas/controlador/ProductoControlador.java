package com.gestion.facturas.controlador;

import java.util.List;

import com.gestion.facturas.servicios.ProductosServices;
import com.gestion.facturas.modelo.Producto;

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
@RequestMapping("/api/productos")
public class ProductoControlador {
	@Autowired
	private ProductosServices productosServices;

	@GetMapping("/listar")
	public ResponseEntity<List<Producto>> listarProductos() {
		return new ResponseEntity<>(productosServices.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id_producto}")
	public ResponseEntity<Producto> obtenerFactura(@PathVariable Long id_producto) {
		return new ResponseEntity<>(productosServices.findById(id_producto), HttpStatus.OK);
	}

	@PostMapping("/crear")
	public ResponseEntity<Producto> crearProductos(@RequestBody Producto producto) {
		return new ResponseEntity<>(productosServices.save(producto), HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Producto> actualizarProductos(@PathVariable Long id, @RequestBody Producto producto) {
		Producto productoEncontrado = productosServices.findById(id);

		if (productoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		try {

			productoEncontrado.setNombre(producto.getNombre());
			productoEncontrado.setPrecio(producto.getPrecio());
			productoEncontrado.setStock(producto.getStock());
			productoEncontrado.setImagen(producto.getImagen());

			return new ResponseEntity<>(productosServices.save(productoEncontrado), HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminarProductos(@PathVariable Long id) {
		productosServices.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
