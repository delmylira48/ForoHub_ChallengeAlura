package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.IPerfilRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.Perfil;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.PerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.perfil.roles.Roles;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.IUsuarioRepository;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioPerfilService {

    @Autowired
    private IUsuarioPerfilRepository usuarioPerfilRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IPerfilRepository perfilRepository;

    @Transactional
    public DetallesRegistroUserPerfilDTO agregarUsuario(RegistroUsuarioPerfilDTO registroUsuarioPerfilDTO) {
        var usuarioDTO= registroUsuarioPerfilDTO.usuario();
        List<PerfilDTO> perfiles= registroUsuarioPerfilDTO.perfiles();


        Usuario usuarioGuardado;
        var opcionalUser = usuarioRepository.findByCorreo(usuarioDTO.correo());
        if (opcionalUser.isPresent()) {
            throw new RuntimeException("usuario existente");
        }else{
            usuarioGuardado = usuarioRepository.save(new Usuario(usuarioDTO));
        }

        List<Perfil> perfilesGuardado= new ArrayList<>();
        if (perfiles==null){
            perfiles= new ArrayList<>();
            perfiles.add(new PerfilDTO(null, Roles.USER));
        }
        perfiles.forEach(perfil ->{
            var opcionalPerfil = perfilRepository.findByRol(perfil.rol());
            Perfil perfilAGuardar=new Perfil(perfil);
            if (!opcionalPerfil.isPresent()){
                perfilAGuardar =perfilRepository.save(perfilAGuardar);
            }else{
                perfilAGuardar=opcionalPerfil.get();
            }
            perfilesGuardado.add(perfilAGuardar);
        });

        // Guardar las relaciones UsuarioPerfil
        for (Perfil perfil : perfilesGuardado) {
            UsuarioPerfil usuarioPerfil = new UsuarioPerfil(perfil, usuarioGuardado);
            usuarioPerfilRepository.save(usuarioPerfil);
        }

        var userDetalles = new UsuarioDTO(usuarioGuardado);
        List<PerfilDTO> nuevosPerfiles = perfilesGuardado.stream().map(n -> new PerfilDTO(n)).collect(Collectors.toList());
        return new DetallesRegistroUserPerfilDTO(nuevosPerfiles,userDetalles);
    }
}
