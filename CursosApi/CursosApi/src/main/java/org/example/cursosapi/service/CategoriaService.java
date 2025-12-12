package org.example.cursosapi.service;

import org.example.cursosapi.entity.Categoria;
import org.example.cursosapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public List<Categoria> listar() {
        return repo.findAll();
    }

    public Categoria guardar(Categoria c) {
        return repo.save(c);
    }

    public Optional<Categoria> buscar(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}