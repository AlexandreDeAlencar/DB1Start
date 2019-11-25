package com.db1.poo;

public class Aluno extends Pessoa {

    private double nota;


    public Aluno(String nome, String email) {
        super(nome, email);

    }

    public Aluno(String nome, String email, double nota) {
        super(nome, email);
        this.nota = nota;
    }

    public double getNota() {

        return nota;
    }


    @Override
    public String toString() {
        return super.toString() + " Aluno{" +
                "nota=" + nota +
                '}';
    }
}
