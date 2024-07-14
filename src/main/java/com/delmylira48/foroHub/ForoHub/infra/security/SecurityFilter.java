package com.delmylira48.foroHub.ForoHub.infra.security;

import com.delmylira48.foroHub.ForoHub.domain.manejousuarios.usuario.IUsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private IUsuarioRepository usuarioRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //obtener el autenticacionHeader del header
        var autenticacionHeader = request.getHeader("Authorization");
        if(autenticacionHeader!=null) {
            var token = autenticacionHeader.replace("Bearer ", "");
            //el usser tiene sesión?
            var subject = tokenService.getSubject(token);
            if(subject!=null){
                //autenticacionHeader valid
                var user= usuarioRepository.findByCorreo(subject);
                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.get().getAuthorities()); //forzar el inicio de sesion
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
