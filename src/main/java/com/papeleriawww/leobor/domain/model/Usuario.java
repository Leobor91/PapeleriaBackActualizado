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
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "tipo_documento", length = 50)
    private String documentType;

    @Column(name = "numero_documento", length = 50)
    private String documentNumber;

    @Column(name = "nombre", length = 100)
    private String name;

    @Column(name ="apellido" ,length = 100)
    private String lastName;

    @Column(name ="correo",length = 100, unique = true)
    private String email;

    @Column(name ="direccion" ,length = 255)
    private String address;

    @Column(name ="telefono", length = 20)
    private String phone;

    @Column(length = 50)
    private String username;

    @Column(length = 100)
    private String password;


}
