package com.virtusconsultoria.repository;

import com.virtusconsultoria.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Clientes, Long> { }
