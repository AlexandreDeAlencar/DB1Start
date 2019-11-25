package com.db1.contacorrentepoo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Operacao {
    private Date dataOperacao;
    private double valorOperacao;

    public Operacao( double valorOperacao) {
        this.dataOperacao = dataAtual();
        this.valorOperacao = valorOperacao;
    }

    public Date dataAtual() {
        Calendar calendar = new GregorianCalendar(); Date date = new Date(); calendar.setTime(date);
        return calendar.getTime();
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }



}
