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
@Table(name = "proveedores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "nit_proveedor")
    private long nit;

    @Column(name = "nombre_proveedor")
    private String nombre;

    @Column(name = "ciudad_proveedor")
    private String ciudad;

    @Column(name = "direccion_proveedor")
    private String direccion;

    @Column(name = "telefono_proveedor")
    private String telefono;
}
