package com.adso.pollos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Representación de una tabla en la base de datos (no crea un bean)
@Data // Getters y setters
@Table(name = "Usuario") // Nombre de la tabla en la base de datos
public class Usuario {
    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Id es auto incremental
    // Nombre de la columna en la base de datos
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "correo")
    private String correo;
}