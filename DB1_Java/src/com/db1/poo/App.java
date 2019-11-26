package com.db1.poo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class App {

    public static void main(String[] args) throws ParseException {
        Aluno aluno1 = new Aluno("Alexandre de Alencar Ferreira","falexandrealencar@hotmail.com" );

        Aluno aluno2 = new Aluno("João Silva", "joão.silva@db1.com.br");

        Professor professor1 = new Professor("Igor Silva","igor.silva@db1.com.br", 3000);

        Materia materia1 = new Materia("POO", "Abstração, encapsulamento, polimorfismo e herança", 10.5, professor1, 3);



        Date data = new Date();
        ArrayList<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno1);
        alunos.add(aluno2);
        Aula aula1 = new Aula(materia1, alunos, data);
        System.out.println(aluno1.toString());
    }

}
