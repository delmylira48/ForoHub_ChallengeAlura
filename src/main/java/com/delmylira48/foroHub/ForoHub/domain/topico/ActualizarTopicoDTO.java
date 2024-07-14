package com.delmylira48.foroHub.ForoHub.domain.topico;

public record ActualizarTopicoDTO(Long id,
                                  String titulo,
                                  String contenido,
                                  Estatus status) {
}
