package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;

public abstract class Pessoa {

   private String nome;
   private String email;

    public Pessoa(String nome,String email){
        if (email == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Email não pode ser nulo");
        }
        if (nome == null){
            throw new CampoNaoPodeSerNull("Nome não pode ser nulo");
        }
        this.nome=nome;
        this.email=email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
