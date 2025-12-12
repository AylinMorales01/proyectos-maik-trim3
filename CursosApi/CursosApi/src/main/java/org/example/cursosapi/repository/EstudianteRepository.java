package org.example.cursosapi.repository;

import org.example.cursosapi.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    boolean existsByEmail(String email);
}