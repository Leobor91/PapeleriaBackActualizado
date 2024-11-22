package com.papeleriawww.leobor.domain.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder(toBuilder = true)
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(name = "codigo_producto", updatable = false, nullable = false)
    private long codigo;

    @Column(name = "nombre_producto", length = 100)
    private String nombre;

    @Column(name = "nit_proveedor")
    private long nitProveedor;

    @Column(name = "precio_compra")
    private double precioCompra;

    @Column(name = "iva_compra")
    private double ivaCompra;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "cantidad_producto")
    private int cantidad;
}
