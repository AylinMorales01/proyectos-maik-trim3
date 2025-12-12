package org.example.cursosapi.controller;

import org.example.cursosapi.entity.Curso;
import org.example.cursosapi.entity.Estudiante;
import org.example.cursosapi.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<Estudiante> listar() { return service.listar(); }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Estudiante e) {
        try {
            return ResponseEntity.ok(service.registrar(e));
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<List<Curso>> listarCursosEstudiante(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerCursosPorEstudiante(id));
    }
}