package com.db1.cidades_api.domain.entity;

import javax.persistence.*;

@Entity
@Table(name= "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saldo")
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;

    @OneToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    public Conta() {
    }

    public Conta(double saldo, Agencia agencia, Cliente cliente) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
