package com.db1.cidades_api.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name= "agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "numero", length = 5)
    private String numero;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Conta> contas;

    public Agencia (){
    }

    public Agencia( String numero, Cidade cidade) {
        this.numero = numero;
        this.cidade = cidade;
        this.contas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
