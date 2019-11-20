package com.db1.poo;

public class Materia {

       private  String nome;
       private  String descrição;
       private double cargahoraria;
       private Professor professor;
       private  int quantidadedeaulas;

    public Materia(String nome, String descrição, double cargahoraria, Professor professor, int quantidadedeaulas) {
        this.nome = nome;
        this.descrição = descrição;
        this.cargahoraria = cargahoraria;
        this.professor = professor;
        this.quantidadedeaulas = quantidadedeaulas;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nome='" + nome + '\'' +
                ", descrição='" + descrição + '\'' +
                ", cargahoraria=" + cargahoraria +
                ", professor=" + professor +
                ", quantidadedeaulas=" + quantidadedeaulas +
                '}';
    }
}
