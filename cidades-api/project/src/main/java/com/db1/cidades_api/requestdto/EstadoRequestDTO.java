package com.db1.cidades_api.requestdto;

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
