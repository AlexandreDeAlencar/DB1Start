package com.db1.poo;

import org.junit.Assert;
import org.junit.Test;


class ProfessorTest {

    @Test
    public void criarProfessorConstrutor(){
        String nome = "maiko";
        String email = "maiko.cunha@db1.com.br";
        double salario = 3000;
        Professor professor = new Professor(nome, email, salario);
        Assert.assertEquals(email, professor.getEmail());
        Assert.assertEquals(nome, professor.getNome());
        Assert.assertEquals(salario, professor.getSalario(), 0.0);
    }

}