package com.db1.cidades_api.responsedto;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Estado;

import java.util.ArrayList;
import java.util.List;

public class CidadeResponseDTO {
    private String nome;
    private Estado uf;
    private List<Agencia> agencias;

    public CidadeResponseDTO() {
    }

    public CidadeResponseDTO(String nome, Estado uf) {
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
