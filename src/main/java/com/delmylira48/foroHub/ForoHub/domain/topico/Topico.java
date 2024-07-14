package com.delmylira48.foroHub.ForoHub.domain.topico;

import com.delmylira48.foroHub.ForoHub.domain.curso.Curso;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String contenido;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private Estatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Curso curso;

    public Topico(TopicoDTO topicoDTO) {
        this.titulo=topicoDTO.titulo();
        this.contenido= topicoDTO.contenido();
    }

    public void actualizarDatos(ActualizarTopicoDTO actualizarTopicoDTO) {
        if (actualizarTopicoDTO.titulo()!=null){
            this.titulo=actualizarTopicoDTO.titulo();
        }

        if (actualizarTopicoDTO.status()!=null){
            this.status= actualizarTopicoDTO.status();
        }

        if (actualizarTopicoDTO.contenido()!=null){
            this.contenido= actualizarTopicoDTO.contenido();
        }
    }

    public void eliminarTopic() {
        this.status=Estatus.ELIMINADO;
    }
}
