package org.example.cursosapi.service;

import org.example.cursosapi.entity.Curso;
import org.example.cursosapi.repository.CategoriaRepository;
import org.example.cursosapi.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repo;
    @Autowired
    private CategoriaRepository catRepo;

    public Curso guardar(Curso curso) {
        if (curso.getCategoria() == null || !catRepo.existsById(curso.getCategoria().getId())) {
            throw new RuntimeException("Error: La categoría asignada no existe.");
        }
        return repo.save(curso);
    }
}