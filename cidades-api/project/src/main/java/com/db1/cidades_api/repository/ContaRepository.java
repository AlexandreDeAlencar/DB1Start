package com.db1.cidades_api.repository;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.domain.entity.Conta;
import com.db1.cidades_api.domain.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
   List<Conta> findAllByAgencia(Agencia agencia);
    List<Conta> findAllByCliente(Cliente cliente);
}
