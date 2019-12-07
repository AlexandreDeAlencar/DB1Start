package com.db1.cidades_api.requestdto;

import com.db1.cidades_api.domain.entity.Conta;

public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
