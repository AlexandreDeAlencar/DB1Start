package com.db1.cidades_api.dto;

import com.db1.cidades_api.domain.entity.Conta;
import org.springframework.stereotype.Component;

import javax.persistence.*;

public class ClienteRequestDTO {

    private String nome;
    private String cpf;
    private String telefone;
    private Conta conta;

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
