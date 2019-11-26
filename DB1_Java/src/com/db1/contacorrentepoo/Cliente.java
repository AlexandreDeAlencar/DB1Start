package com.db1.contacorrentepoo;

public class Cliente {
    private String cpf;
    private String nomeTitular;

    public Cliente(String nomeTitular, String cpf) {
        if (nomeTitular == null || nomeTitular.isEmpty()){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Nome do titular da conta não pode ser nulo");
        }
        if (cpf == null||cpf.isEmpty()){
            throw new CampoNaoPodeSerNull("CPF do titular da conta não pode ser nulo");
        }

        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null||cpf.isEmpty()){
            throw new CampoNaoPodeSerNull("CPF do titular da conta não pode ser nulo");
        }
        this.cpf = cpf;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        if (nomeTitular == null || nomeTitular.isEmpty()){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Nome do titular da conta não pode ser nulo");
        }
        this.nomeTitular = nomeTitular;
    }
}
