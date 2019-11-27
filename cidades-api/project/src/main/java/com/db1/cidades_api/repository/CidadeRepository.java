package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository <Cidade, Long> {

}
