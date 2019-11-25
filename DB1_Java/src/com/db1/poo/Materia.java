package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;

public class Materia {

       private  String nome;
       private  String descricao;
       private double cargahoraria;
       private Professor professor;
       private  int quantidadedeaulas;

    public Materia(String nome, String descricao, double cargahoraria, Professor professor, int quantidadedeaulas) {
        if (descricao == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Descrição não pode ser nula");
        }

        if (nome == null){
            throw new CampoNaoPodeSerNull("Nome não pode ser nulo");
        }

        this.nome = nome;
        this.descricao = descricao;
        this.cargahoraria = cargahoraria;
        this.professor = professor;
        this.quantidadedeaulas = quantidadedeaulas;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getCargahoraria() {
        return cargahoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public int getQuantidadedeaulas() {
        return quantidadedeaulas;
    }

    public void trocaProfessor(Professor professor){
        this.professor = professor;
    }


    @Override
    public String toString() {
        return "Materia{" +
                "nome='" + nome + '\'' +
                ", descrição='" + descricao + '\'' +
                ", cargahoraria=" + cargahoraria +
                ", professor=" + professor +
                ", quantidadedeaulas=" + quantidadedeaulas +
                '}';
    }
}
