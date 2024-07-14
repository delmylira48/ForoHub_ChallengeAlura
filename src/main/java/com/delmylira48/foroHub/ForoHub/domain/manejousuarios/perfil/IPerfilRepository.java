package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPerfilRepository extends JpaRepository<Perfil, Long> {
    Optional<Perfil> findByRol(Roles rol);
}
