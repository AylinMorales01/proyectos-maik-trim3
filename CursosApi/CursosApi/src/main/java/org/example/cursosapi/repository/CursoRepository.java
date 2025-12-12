package org.example.cursosapi.repository;

import org.example.cursosapi.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
