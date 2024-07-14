package com.delmylira48.foroHub.ForoHub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findByNombre(String nombre);
}
