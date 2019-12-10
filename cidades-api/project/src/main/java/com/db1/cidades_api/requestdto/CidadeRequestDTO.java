package com.db1.cidades_api.requestdto;

import com.db1.cidades_api.domain.entity.Estado;

public class CidadeRequestDTO {

    private String nome;
    private Estado estado;

    public CidadeRequestDTO() {
    }

    public CidadeRequestDTO(String nome, Estado uf) {
        this.estado = uf;
    }

    public String getNome() {
        return nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
