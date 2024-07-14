package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.CursoDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioLessDTO;

import java.time.LocalDateTime;

public record DetalleTopicoDTO(
        Long id,
        String titulo,
        String contenido,
        LocalDateTime fecha,
        Estatus status,
        UsuarioLessDTO actor,
        CursoDTO curso
) {
    public DetalleTopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getContenido(), topico.getFecha(), topico.getStatus(),new UsuarioLessDTO(topico.getAutor()), new CursoDTO(topico.getCurso()));
    }
}
