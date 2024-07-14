package com.delmylira48.foroHub.ForoHub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(
        Long id,
        @NotBlank
        String nombre,
        @NotNull
        Categoria categoria
) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
