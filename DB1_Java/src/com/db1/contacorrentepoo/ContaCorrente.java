package com.db1.contacorrentepoo;

import java.util.*;
import java.util.stream.Collectors;

public class ContaCorrente {
    private double saldo;
    private String nomeTitular;
    private String cpf;
    private Extrato extrato;

    public ContaCorrente(double saldo, String nomeTitular, String cpf) {
        this.saldo = saldo;

        if (nomeTitular == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Nome do titular da conta não pode ser nulo");
        }
        if (cpf == null){
            throw new CampoNaoPodeSerNull("CPF do titular da conta não pode ser nulo");
        }

        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        Deposito depositoInical = new Deposito(saldo);
        ArrayList<Operacao> extratoInicial = new ArrayList<Operacao>(Arrays.asList(depositoInical));
        Extrato extrato = new Extrato(extratoInicial);
        this.extrato = extrato ;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Extrato getExtrato() {
        return extrato;
    }

    public void setExtrato(Extrato extrato) {
        this.extrato = extrato;
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
            System.out.println("A conta não possui saldo suficiente para realizar a operação de saque desejada");
        }
    }

    public void transferir(double valor, String nomeTitularTransferencia, String cpfTitularTransferencia){
        Transacao transacao = new Transacao(valor, nomeTitularTransferencia, cpfTitularTransferencia );
        if  (this.saldo>transacao.getValorOperacao()) {
            this.saldo -= transacao.getValorOperacao();
            this.extrato.addOperacao(transacao);
        } else {
            System.out.println("A conta não possui saldo suficiente para realizar a operação de transferência desejada");
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
