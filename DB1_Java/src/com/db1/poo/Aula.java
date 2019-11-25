package com.db1.poo;

import com.db1.contacorrentepoo.CampoNaoPodeSerNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aula {

    private Materia materia;
    private List<Aluno> alunos = new ArrayList<Aluno>();

    private Date data;

    public Aula(Materia materia, Date data) {
        if (data == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Data não pode ser nulo");
        }

        this.materia = materia;
        this.data = data;
    }

    public Aula(Materia materia, List<Aluno> alunos, Date data) {

        if (data == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Data não pode ser nulo");
        }

        this.materia = materia;
        this.alunos = alunos;
        this.data = data;
    }

    public void darPresenca(Aluno aluno) {
        if (aluno == null) {
            throw new CampoNaoPodeSerNull("Aluno não pode ser nulo");
        }
        this.alunos.add(aluno);
    }

    public int quantidadeDeAlunosPresentes() {
        return this.alunos.size();
    }


    public Materia getMateria()
    {
        return materia;
    }

    public List<Aluno> getAlunos() {

        return alunos;
    }

    public Date getData()
    {
        return data;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "materia=" + materia +
                ", alunos=" + alunos +
                ", data=" + data +
                '}';
    }
}
