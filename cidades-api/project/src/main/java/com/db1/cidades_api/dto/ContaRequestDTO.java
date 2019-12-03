package com.db1.cidades_api.dto;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cliente;
import org.springframework.stereotype.Component;

import javax.persistence.*;

public class ContaRequestDTO {

    private double saldo;
    private Agencia agencia;
    private Cliente cliente;

    public ContaRequestDTO() {
    }

    public ContaRequestDTO(double saldo, Agencia agencia, Cliente cliente) {
        this.saldo = saldo;
        this.agencia = agencia;
        this.cliente = cliente;
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


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
