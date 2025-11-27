package com.adso.pollos.controller;

import com.adso.pollos.dto.UsuarioRequestDTO;
import com.adso.pollos.dto.UsuarioResponseDTO;
import com.adso.pollos.entity.Usuario;
import com.adso.pollos.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Crea un bean (patrón de diseño singleton, se instancia una sola vez en toda nuestra aplicación
@RestController // Para APIs RESTful (Los métodos devuelven datos directamente (JSON, XML) en el cuerpo de la respuesta HTTP)
@RequiredArgsConstructor // Crea constructor para todos los atributos automáticamente
@RequestMapping("/usuarios") // Crea una ruta (endPoint) general para nuestro controlador
public class UsuarioController {
    // Crea una constante de tipo UsuarioService
    private final UsuarioService usuarioService;

    @PostMapping // Crea ruta (endPoint) de tipo POST (enviar) de tipo especifico
    // Metodo que responde con codigos HTTP personalizados con un cuerpo de UsuarioResponseDTO recibiendo otro objeto UsuarioRequestDTO
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        // Crea una respuesta de tipo UsuarioResponseDTO, apuntando al metodo de nuestro service que responde con UsuarioResponseDTO
        UsuarioResponseDTO response = usuarioService.crearUsuario(usuarioRequestDTO);
        // Retornamos la respuesta a nuestro cliente, con codigo 201 (CREADO)
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
       List<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios();

       return ResponseEntity.status(HttpStatus.FOUND).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuario(@PathVariable Long id) {
        UsuarioResponseDTO response = usuarioService.obtenerUsuario(id).orElse(null);
        if(response != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<UsuarioResponseDTO>> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioResponseDTO> response = usuarioService.actualizarUsuario(id, usuarioRequestDTO);

    if (response != null) {
        return ResponseEntity.status(HttpStatus.OK).body(response);
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
}
}