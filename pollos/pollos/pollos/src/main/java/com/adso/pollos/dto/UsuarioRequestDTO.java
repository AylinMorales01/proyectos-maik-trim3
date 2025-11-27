package com.adso.pollos.dto;

import lombok.Data;

@Data //Getters y setters
public class UsuarioRequestDTO {
    private String nombre;
    private Integer edad;
    private String correo;
    public Object getApellido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApellido'");
    }
}

// Data Transfer Object = DTO, es el que viaja por internet para evitar exponer nuestra entidad
// Objeto de transferen