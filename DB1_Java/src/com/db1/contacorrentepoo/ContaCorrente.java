package com.db1.contacorrentepoo;

import java.util.*;
import java.util.stream.Collectors;

public class ContaCorrente {
    private double saldo;
    private String numero;
    private String agencia;
    private Extrato extrato;
    private Cliente cliente;

    public ContaCorrente(double saldoInicial, String numero, String agencia, Cliente cliente) {
        if (numero == null ||numero.isEmpty()){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("O número da conta não pode ser nulo");
        }
        if (agencia == null||agencia.isEmpty()){
            throw new CampoNaoPodeSerNull("A agência  da conta não pode conter valor nulo");
        }

        this.saldo = saldoInicial;
        this.numero = numero;
        this.agencia = agencia;
        this.cliente= cliente;
        Deposito depositoInical = new Deposito(saldo);
        ArrayList<Operacao> extratoInicial = new ArrayList<>(Arrays.asList(depositoInical));
        Extrato extrato = new Extrato(extratoInicial);
        this.extrato = extrato ;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null ||numero.isEmpty()){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("O número da conta não pode ser nulo");
        }
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        if (agencia == null||agencia.isEmpty()){
            throw new CampoNaoPodeSerNull("A agência  da conta não pode conter valor nulo");
        }
        this.agencia = agencia;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar (double valor){
        Deposito deposito = new Deposito(valor);
        this.saldo += deposito.getValorOperacao();
        this.extrato.addOperacao(deposito);
    }

    public void sacar(double valor){
        Saque saque = new Saque(valor);
        if (this.saldo>saque.getValorOperacao()) {
                this.saldo -= saque.getValorOperacao();
                this.extrato.addOperacao(saque);
        } else {
            throw new RuntimeException("A conta não possui saldo suficiente para realizar a operação de saque desejada");
        }
    }

    public void transferir(double valor, ContaCorrente contaCorrenteTransferencia){
        Transacao transacaoSaida = new Transacao(-valor, contaCorrenteTransferencia );
        Transacao transacaoEntrada = new Transacao(valor, this);
        if  (this.saldo>transacaoSaida.getValorOperacao() && valor >=0) {
            this.saldo += transacaoSaida.getValorOperacao();
            this.extrato.addOperacao(transacaoSaida);
            contaCorrenteTransferencia.setSaldo(contaCorrenteTransferencia.saldo + valor);
            contaCorrenteTransferencia.extrato.addOperacao(transacaoEntrada);
        } else if (this.saldo<transacaoSaida.getValorOperacao()) {
            throw new RuntimeException("A conta não possui saldo suficiente para realizar a operação de saque desejada");
        } else if (valor < 0) {
            throw new RuntimeException("A operacação não pode conter valor inferior a R$ 0,00");
        }
    }

    public void showExtrato(Date dataInicial, Date dataFinal){
        //Filtrar as lista de operações da conta corrente que ocorreram dentro do período inserido
        List<Operacao> showExtratoDeposito  = this.extrato.getListaDeOperacoes().stream()
                .filter(e -> (e.getDataOperacao().before(dataFinal) && e.getDataOperacao().after(dataInicial))||
                        (e.getDataOperacao().equals(dataFinal) ||  e.getDataOperacao().equals(dataInicial)))
                .collect(Collectors.toList());

        //Ordenar as operações em ordem cronologica;
        showExtratoDeposito.sort(Comparator.comparing(Operacao::getDataOperacao));

        double saldoIncial = this.saldo -  this.extrato.saldoExtrato();
        System.out.println(showExtratoDeposito.get(0).getDataOperacao() + " R$ " + saldoIncial  + " Saldo inicial");

        for (int i = 0; i < showExtratoDeposito.size(); i++) {
            System.out.println( showExtratoDeposito.get(i).getDataOperacao() +
                    " R$ " +  showExtratoDeposito.get(i).getValorOperacao() + "  " +
                   showExtratoDeposito.get(i).getClass().getName().replaceAll("com.db1.contacorrentepoo.", "") + "  ");
        }

        System.out.println(showExtratoDeposito.get(showExtratoDeposito.size()-1).getDataOperacao() + " R$ " + this.saldo + " Saldo Final");
    }

    public Extrato  getExtrato(Date dataInicial, Date dataFinal){
        List<Operacao> extratoDeposito  = this.extrato.getListaDeOperacoes().stream()
                .filter(e -> (e.getDataOperacao().before(dataFinal) && e.getDataOperacao().after(dataInicial))||
                        (e.getDataOperacao().equals(dataFinal) ||  e.getDataOperacao().equals(dataInicial)))
                .collect(Collectors.toList());
        extratoDeposito.sort(Comparator.comparing(Operacao::getDataOperacao));
        Extrato extrato = new Extrato(extratoDeposito);
        return extrato;

    }

    public static Date dataAtual() {
        Calendar calendar = new GregorianCalendar(); Date date = new Date(); calendar.setTime(date);
        return calendar.getTime();
    }

}
