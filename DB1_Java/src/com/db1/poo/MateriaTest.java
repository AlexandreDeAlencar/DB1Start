package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;
import org.junit.Assert;
import org.junit.Test;

public class MateriaTest {

    @Test
    public void deveJogarExeceptionDescricaoNulo(){
        Professor professor1 = new Professor("Igor Silva","igor.silva@db1.com.br", 3000);
        String nome = "Alexandre";
        String descricao =null;
        double cargahoraria = 10.5;
        int quantidadedeaulas = 3;
        try {
            Materia materia1 = new Materia(nome, descricao,
                    cargahoraria, professor1, quantidadedeaulas);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Descrição não pode ser nula", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComNomeNulo(){
        Professor professor1 = new Professor("Igor Silva","igor.silva@db1.com.br", 3000);
        String nome = null;
        String descricao = "Abstração, encapsulamento, polimorfismo e herança";
        double cargahoraria = 10.5;
        int quantidadedeaulas = 3;
        try {
            Materia materia1 = new Materia(nome, descricao,
                    cargahoraria, professor1, quantidadedeaulas);
        } catch (CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Nome não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }



    @Test
    public void criarMateriaConstrutor(){
        Professor professor1 = new Professor("Igor Silva","igor.silva@db1.com.br", 3000);
        String nome = "Alexandre";
        String descricao = "Abstração, encapsulamento, polimorfismo e herança";
        double cargahoraria = 10.5;
        int quantidadedeaulas = 3;
        Materia materia1 = new Materia(nome, descricao,
                cargahoraria, professor1, quantidadedeaulas);
        Assert.assertEquals(nome, materia1.getNome());
        Assert.assertEquals(descricao, materia1.getDescricao());
        Assert.assertEquals(cargahoraria, materia1.getCargahoraria(),0.0);
        Assert.assertEquals(quantidadedeaulas, materia1.getQuantidadedeaulas());

    }

}