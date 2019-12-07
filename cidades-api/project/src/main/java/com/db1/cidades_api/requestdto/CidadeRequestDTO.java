package com.db1.cidades_api.requestdto;

import com.db1.cidades_api.domain.entity.Estado;

public class CidadeRequestDTO {

    private String nome;
    private Estado uf;

    public CidadeRequestDTO() {
    }

    public CidadeRequestDTO(String nome, Estado uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public Estado getUf() {
        return uf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(Estado uf) {
        this.uf = uf;
    }

}
