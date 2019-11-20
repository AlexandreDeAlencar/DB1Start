package com.db1.poo;

import org.junit.Assert;
import org.junit.Test;

class MateriaTest {

    @Test
    public void criarAlunoConstrutor(){
        String nome = "Alexandre de Alencar Ferreira";
        String email = "falexandrealencar@hotmail.com";
        Aluno aluno1 = new Aluno(nome, email);
        Assert.assertEquals(nome, aluno1.getNome());
        Assert.assertEquals(email, aluno1.getEmail());
    }

}