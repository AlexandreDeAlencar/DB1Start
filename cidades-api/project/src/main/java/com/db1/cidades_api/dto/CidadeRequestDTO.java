package com.db1.cidades_api.dto;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Estado;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CidadeRequestDTO {

    private String nome;
    private Estado uf;
    private List<Agencia> agencias;

    public CidadeRequestDTO() {
    }

    public CidadeRequestDTO(String nome, Estado uf) {
        this.uf = uf;
        this.agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public Estado getUf() {
        return uf;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

}
