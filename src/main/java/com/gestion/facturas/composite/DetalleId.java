package com.gestion.facturas.composite;

import java.io.Serializable;
import java.util.Objects;

public class DetalleId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long num_detalle;
	private Long id_factura;

	public DetalleId() {

	}

	public DetalleId(Long num_detalle, Long id_factura) {
		super();
		this.num_detalle = num_detalle;
		this.id_factura = id_factura;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleId accountId = (DetalleId) o;
        return num_detalle.equals(accountId.num_detalle) &&
        		id_factura.equals(accountId.id_factura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_detalle, id_factura);
    }
	

}
