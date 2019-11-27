package com.db1.cidades_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.cidades_api.domain.entity.Estado;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long>{
    Optional<Estado> findByNome(String nome);
}



