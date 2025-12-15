package org.example.cursosapi.controller;

import org.example.cursosapi.entity.Categoria;
import org.example.cursosapi.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listar() { return service.listar(); }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Categoria c) {
        return ResponseEntity.ok(service.guardar(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtener(@PathVariable Long id) {
        return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) { service.eliminar(id); }
}