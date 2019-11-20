package com.db1.poo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;


class AulaTest {

    @Test
    public void criarAulaConstrutor(){
        Date data = new Date();
        Professor professor1 = new Professor("Igor Silva","igor.silva@db1.com.br", 3000);
        Materia materia1 = new Materia("POO", "Abstração, encapsulamento, polimorfismo e herança", 10.5, professor1, 3);
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno1 = new Aluno("Alexandre de Alencar Ferreira","falexandrealencar@hotmail.com" );
        Aluno aluno2 = new Aluno("João Silva", "joão.silva@db1.com.br");
        alunos.add(aluno1);
        alunos.add(aluno2);
        Aula aula1 = new Aula(materia1, alunos, data);
        Assert.assertEquals(alunos, aula1.getAlunos());
        Assert.assertEquals(data, aula1.getData());
        Assert.assertEquals(materia1, aula1.getMateria());
    }
}