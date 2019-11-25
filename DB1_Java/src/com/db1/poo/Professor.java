package com.db1.poo;

public class Professor extends Pessoa{

    private  double salario;

    public Professor(String nome, String email) {
        super(nome, email);
    }

    public Professor(String nome, String email, double salario) {

        super(nome, email);
        this.salario = salario;
    }

    public double getSalario() {

        return salario;
    }


    @Override
    public String toString() {
        return super.toString() +  " Professor{" +
                "salario=" + salario +
                '}';
    }
}
