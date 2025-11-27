package com.adso.pollos.repository;

import com.adso.pollos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Crea un bean (patrón de diseño singleton, se instancia una sola vez en toda la aplicación)
// Accedemos a JpaRepository donde están los métodos que vamos a heredad para no hacer consultas sql nativas
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}