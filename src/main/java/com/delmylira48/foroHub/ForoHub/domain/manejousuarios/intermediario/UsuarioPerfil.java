package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.Perfil;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.PerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario_perfil_relaciones")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    //@MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    //@MapsId("perfilId")
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

    public UsuarioPerfil(UsuarioPerfilDTO registroIntermedio) {
        this.usuario=new Usuario(registroIntermedio.usuario());
        this.perfil=new Perfil(registroIntermedio.perfiles());
    }

    public UsuarioPerfil(Perfil perfil, Usuario usuarioGuardado) {
        this.perfil=perfil;
        this.usuario=usuarioGuardado;
    }
}
