package com.delmylira48.foroHub.ForoHub.controller;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.AutenticadorUsuarioDTO;
import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.Usuario;
import com.delmylira48.foroHub.ForoHub.infra.security.JwtTokenDTO;
import com.delmylira48.foroHub.ForoHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario/login")
public class AutenticacionController {

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity autenticarUsuario(@RequestBody @Valid AutenticadorUsuarioDTO autenticadorUsuarioDTO){
            Authentication autenticacionToken = new UsernamePasswordAuthenticationToken(autenticadorUsuarioDTO.login(), autenticadorUsuarioDTO.clave());

            var usuarioAutenticado = authenticationManager.authenticate(autenticacionToken);
            var JwtToken = tokenService.generateToken((Usuario) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new JwtTokenDTO(JwtToken) );
        }


}
