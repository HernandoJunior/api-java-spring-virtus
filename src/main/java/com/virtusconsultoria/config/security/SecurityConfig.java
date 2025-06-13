package com.virtusconsultoria.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        //ROTAS COLABORADORES
                        .requestMatchers(HttpMethod.POST, "/colaborador").permitAll()
                        .requestMatchers(HttpMethod.POST, "/colaborador/auth").permitAll()
                        .requestMatchers(HttpMethod.POST, "/colaborador/cadastrarcol").permitAll()
                        .requestMatchers(HttpMethod.GET, "/colaborador/listarcol").permitAll()
                        //ROTAS VENDAS
                        .requestMatchers(HttpMethod.POST, "/vendas/cadastrarven").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/vendas/listarven").hasAnyRole("ADMIN","USER")
                        //ROTAS CLIENTES
                        .requestMatchers(HttpMethod.POST, "/clientes/importar").hasAnyRole("USER", "ADMIN")
                        .anyRequest().authenticated())
                .addFilterBefore(
                        verificarToken,
                        UsernamePasswordAuthenticationFilter.class
                ).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
