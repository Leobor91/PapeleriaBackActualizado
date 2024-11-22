package com.papeleriawww.leobor.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_ventas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {

    @Id
    @Column(name = "codigo_detalle_venta")
    private String codigoDetalleVenta;

    @Column(name = "cantidad_producto")
    private int cantidadProducto;

    @Column(name = "codigo_producto")
    private long codigoProducto;

    @Column(name = "codigo_venta")
    private long codigoVenta;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name = "valor_venta")
    private double valorVenta;

    @Column(name = "valor_iva")
    private double valorIva;
}
