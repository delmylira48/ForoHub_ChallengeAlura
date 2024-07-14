package com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario;

import com.delmylira48.foroHub.ForoHub.domain.curso.CursoDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario.IUsuarioPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Page<UsuarioLessDTO> listar(Pageable datos){
        Page<Usuario> usuarios = usuarioRepository.findAll(datos);
        return usuarios.map(UsuarioLessDTO::new);
    }
}
