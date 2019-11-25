package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;
import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {

    @Test
    public void deveJogarExeceptionComEmailNulo(){
        String nome ="Alexandre";
        try {
            Aluno aluno = new Aluno(nome, null);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Email não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComNomeNulo(){
        String email ="falexandrealencar@hotmail.com";
        try {
            Aluno aluno = new Aluno(null, email);
        } catch (CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Nome não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void criarAlunoConstrutor(){
        String nome = "Alexandre de Alencar Ferreira";
        String email = "falexandrealencar@hotmail.com";
        Aluno aluno1 = new Aluno(nome, email);
        Assert.assertEquals(nome, aluno1.getNome());
        Assert.assertEquals(email, aluno1.getEmail());
    }


}