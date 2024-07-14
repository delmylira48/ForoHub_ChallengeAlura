package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.roles.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private Roles rol;

    public Perfil(PerfilDTO p) {
        this.rol=p.rol();
    }
}
