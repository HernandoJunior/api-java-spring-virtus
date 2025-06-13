package com.virtusconsultoria.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.virtusconsultoria.model.Colaborador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${minha.chave.secreta}")
    private String palavraSecreta;

    public String gerarToken(Colaborador colaborador){
        try {
            Algorithm algoritmo =Algorithm.HMAC256(palavraSecreta);
            String token = JWT.create()
                    .withIssuer("colaborador")
                    .withSubject(colaborador.getEmail())
                    .withExpiresAt(gerarDataDeExpiracao())
                    .sign(algoritmo);

            return token;
        } catch (JWTCreationException erro) {
            return erro.getMessage();
        }
    }

    public String validarToken(String token){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(palavraSecreta);
            return JWT.require(algoritmo)
                    .withIssuer("colaborador")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException erro) {
            return erro.getMessage();
        }
    }
    public Instant gerarDataDeExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
