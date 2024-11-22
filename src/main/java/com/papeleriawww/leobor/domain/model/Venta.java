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
@Table(name = "ventas")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Venta {

    @Id
    @Column(name = "codigo_venta")
    private String codigoVenta;

    @Column(name = "cedula_cliente")
    private long cedulaCliente;

    @Column(name = "valor_venta")
    private double valorVenta;

    @Column(name = "iva_venta")
    private double ivaVenta;

    @Column(name = "total_venta")
    private double totalVenta;

    @Column(name = "nombre_cliente")
    private String nombreCliente;
}
