package com.virtusconsultoria.repository;


import com.virtusconsultoria.model.Colaborador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    UserDetails findByEmail(String email);
    boolean existsByEmail(String email);

}
