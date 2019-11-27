package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
