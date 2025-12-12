package org.example.cursosapi.service;

import org.example.cursosapi.entity.Curso;
import org.example.cursosapi.entity.Estudiante;
import org.example.cursosapi.repository.CursoRepository;
import org.example.cursosapi.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repo;
    @Autowired
    private CursoRepository cursoRepo;

    public Estudiante registrar(Estudiante est) {
        if (est.getId() == null && repo.existsByEmail(est.getEmail())) {
            throw new RuntimeException("Error: El email ya está registrado.");
        }

        if (est.getCursos() != null && !est.getCursos().isEmpty()) {
            for (Curso c : est.getCursos()) {
                if (!cursoRepo.existsById(c.getId())) {
                    throw new RuntimeException("Error: Uno de los cursos asignados no existe.");
                }
            }
        }
        return repo.save(est);
    }

    public List<Estudiante> listar() {
        return repo.findAll();
    }

    public Optional<Estudiante> buscar(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<Curso> obtenerCursosPorEstudiante(Long id) {
        Estudiante est = repo.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        return est.getCursos();
    }
}