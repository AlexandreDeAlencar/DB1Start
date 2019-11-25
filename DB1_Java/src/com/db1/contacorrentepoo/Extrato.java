package com.db1.contacorrentepoo;

import java.util.ArrayList;
import java.util.List;

public class Extrato {
    private List<Operacao> extrato = new ArrayList<>();

    public Extrato(List<Operacao> operacao) {
        this.extrato = operacao;
    }

    public List<Operacao> getListaDeOperacoes() {
        return extrato;
    }

    public void setExtrato(List<Operacao> extrato) {
        this.extrato = extrato;
    }

    public void addOperacao(Operacao operacao){
        this.extrato.add(operacao);
    }

    public double saldoExtrato(){
        double saldoEstrato=0;
        for (int i =0; i< this.extrato.size(); i++){
            String nomeClasse = this.extrato.get(i).getClass().getName();
            if(nomeClasse == Saque.class.getName() || nomeClasse == Transacao.class.getName()){
                saldoEstrato -= this.extrato.get(i).getValorOperacao();
            } else  saldoEstrato += this.extrato.get(i).getValorOperacao();
        }
        return saldoEstrato;
    }


    public ArrayList<Deposito>  getListDepositos(){
        ArrayList<Deposito> listDeposito = new ArrayList<Deposito>();
        for (int i =0; i< this.extrato.size(); i++){
            String nomeClasse = this.extrato.get(i).getClass().getName();
            if(nomeClasse == Deposito.class.getName()){
                listDeposito.add((Deposito) this.extrato.get(i));
            }
        }
        return listDeposito;
    }

    public ArrayList<Saque>  getListSaques(){
        ArrayList<Saque> listSaque = new ArrayList<Saque>();
        for (int i =0; i< this.extrato.size(); i++){
            String nomeClasse = this.extrato.get(i).getClass().getName();
            if(nomeClasse == Saque.class.getName()){
                listSaque.add((Saque) this.extrato.get(i));
            }
        }
        return listSaque;
    }

    public ArrayList<Transacao>  getListTransacoes(){
        ArrayList<Transacao> listTransacao = new ArrayList<Transacao>();
        for (int i =0; i< this.extrato.size(); i++){
            String nomeClasse = this.extrato.get(i).getClass().getName();
            if(nomeClasse == Transacao.class.getName()){
                listTransacao.add((Transacao) this.extrato.get(i));
            }
        }
        return listTransacao;
    }

}
