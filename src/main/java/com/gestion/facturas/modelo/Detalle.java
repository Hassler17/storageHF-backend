package com.gestion.facturas.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalles", uniqueConstraints = { @UniqueConstraint(columnNames = { "num_detalle", "factura" }) })
public class Detalle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num_detalle;

	@Column(name = "factura")
	private Long factura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@Column(name = "cantidad", nullable = false)
	private Long cantidad;

	@Column(name = "precio", length = 60, nullable = false)
	private String precio;

	public Long getNum_detalle() {
		return num_detalle;
	}

	public void setNum_detalle(Long num_detalle) {
		this.num_detalle = num_detalle;
	}

	public Long getFactura() {
		return factura;
	}

	public void setFactura(Long factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

}
