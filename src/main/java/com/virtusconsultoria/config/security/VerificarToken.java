package com.virtusconsultoria.config.security;

import com.virtusconsultoria.repository.ColaboradorRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//Anotação usada para falar ao string que ele deve gerenciar essa classe
@Component
public class VerificarToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException
    {
        String authorizationHeader = request.getHeader("Authorization");
        String token = "";

        if (authorizationHeader == null){
            token = null;
            System.out.println(token);
            return;
        } else {
            System.out.println("Entrei aqui");
            token = authorizationHeader.replace("Bearer", "").trim();
            String login = tokenService.validarToken(token);

            UserDetails usuarioDetalhes = colaboradorRepository.findByEmail(login);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            usuarioDetalhes,
                            null,
                            usuarioDetalhes.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}