package com.db1.cidades_api.dto;

import com.db1.cidades_api.domain.entity.Cidade;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;


public class EstadoResponseDTO {
    String nome;
    List<Cidade> cidades = new ArrayList<>();

    public EstadoResponseDTO() {
    }

    public EstadoResponseDTO(String nome, List<Cidade> cidades) {
        this.nome = nome;
        this.cidades = cidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
