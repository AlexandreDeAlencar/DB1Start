package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
