package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNome(String nome);
}
