package com.delmylira48.foroHub.ForoHub.domain.curso;

public record CursoDTO(
        Long id,
        String nombre,
        Categoria categoria
) {
    public CursoDTO(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
