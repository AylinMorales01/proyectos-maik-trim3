package org.example.cursosapi.entity;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    private String descripcion;
}