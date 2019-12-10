package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository <Cidade, Long> {
    Optional<Cidade> findByNome(String nome);
    List<Cidade> findByEstadoId(Long estadoId);
    List<Cidade> findAllByNome(String Nome);

}
