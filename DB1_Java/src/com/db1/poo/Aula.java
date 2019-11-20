package com.db1.poo;

import java.util.Date;
import java.util.List;

public class Aula {

    private Materia materia;
    private List<Aluno> alunos;
    private Date data;

    public Aula(Materia materia, List<Aluno> alunos, Date data) {
        this.materia = materia;
        this.alunos = alunos;
        this.data = data;
    }

    public Materia getMateria() {
        return materia;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public Date getData() {
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
