package com.delmylira48.foroHub.ForoHub.controller;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario.DetallesRegistroUserPerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario.RegistroUsuarioPerfilDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.intermediario.UsuarioPerfilService;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioLessDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")

public class ManejoUsuarioController {
    @Autowired
    private UsuarioPerfilService usuarioPerfilService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public DetallesRegistroUserPerfilDTO agregarUsuarioNuevo2(@RequestBody RegistroUsuarioPerfilDTO body){
        return usuarioPerfilService.agregarUsuario(body);
    }

    @GetMapping
    public Page<UsuarioLessDTO> listarUsuarios(@PageableDefault Pageable datos){
        return usuarioService.listar(datos);
    }
}
