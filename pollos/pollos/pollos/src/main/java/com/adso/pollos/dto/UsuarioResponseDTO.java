package com.adso.pollos.dto;

import lombok.Data;

@Data // Getters y setters
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private Integer edad;
    private String correo;
}

// Data Transfer Object = DTO, es el que viaja por internet para evitar exponer nuestra entidad
// Objeto de transferencia de datos