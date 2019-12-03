package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
    Optional<Agencia> findByNumero(String numero);
    List<Agencia> findByCidadeId(Long id);
}
