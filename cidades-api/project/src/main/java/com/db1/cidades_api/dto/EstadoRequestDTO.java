package com.db1.cidades_api.dto;

import com.db1.cidades_api.domain.entity.Cidade;
import org.springframework.stereotype.Component;

import java.util.List;

public class EstadoRequestDTO {

        private String nome;

    public EstadoRequestDTO() {
    }

    public EstadoRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
