package com.db1.cidades_api.responsedto;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Conta;

import java.util.ArrayList;
import java.util.List;

public class AgenciaResponseDTO {
    private String numero;
    private Cidade cidade;
    private List<Conta> contas;

    public AgenciaResponseDTO(){
    }

    public AgenciaResponseDTO(String numero, Cidade cidade) {
        this.numero = numero;
        this.cidade = cidade;
        this.contas = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}