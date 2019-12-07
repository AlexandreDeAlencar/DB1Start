package com.db1.cidades_api.requestdto;

import com.db1.cidades_api.domain.entity.Cidade;

public class AgenciaRequestDTO {

    private String numero;
    private Cidade cidade;

    public AgenciaRequestDTO(){
    }

    public AgenciaRequestDTO(String numero, Cidade cidade) {
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
