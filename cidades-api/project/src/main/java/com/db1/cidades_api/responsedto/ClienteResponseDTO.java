package com.db1.cidades_api.responsedto;

import com.db1.cidades_api.domain.entity.Conta;

public class ClienteResponseDTO {
    private String nome;
    private String cpf;
    private String telefone;
    private Conta conta;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(String nome, String cpf) {
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

    public Conta getConta() {
        return conta;
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

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
