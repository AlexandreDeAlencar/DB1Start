package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;
import org.junit.Assert;
import org.junit.Test;


public class ProfessorTest {

    @Test
    public void deveJogarExeceptionComEmailNulo(){
        String nome ="Alexandre";
        try {
           Professor professor = new Professor( nome, null);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Email não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComNomeNulo(){
        String email ="falexandrealencar@hotmail.com";
        try {
            Professor professor = new Professor( null, email);
        } catch (CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Nome não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }


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