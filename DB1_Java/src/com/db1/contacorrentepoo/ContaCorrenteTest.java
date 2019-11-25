package com.db1.contacorrentepoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ContaCorrenteTest {

    @Test
    public void deveMostrarExtrato(){
        int saldo1 = 5000;
        String nome1 = "Alexandre";
        String cpf1 = "07193849905";
        Date datainicial;
        Date datafinal;
        datainicial = dataAtual();
        Saque saque1 = new Saque(1000);
        Deposito deposito1 = new Deposito(5000);
        Deposito deposito2 = new Deposito(400);
        ArrayList<Operacao> operacoes = new ArrayList<>(
                Arrays.asList(deposito1, deposito2, saque1));
        Extrato extrato1 = new Extrato(operacoes);
        ContaCorrente contaAlexandre = new ContaCorrente(saldo1, nome1, cpf1);
        datafinal= dataAtual();
        contaAlexandre.depositar(400);
        contaAlexandre.sacar(1000);
        Assert.assertEquals(extrato1.saldoExtrato(), contaAlexandre.getExtrato(datainicial,datafinal).saldoExtrato(),0.0);
        Assert.assertEquals(extrato1.getListaDeOperacoes().get(0).getValorOperacao(),
                contaAlexandre.getExtrato(datainicial,datafinal).getListaDeOperacoes().get(0).getValorOperacao(),0.0);
    }


    public static Date dataAtual() {
        Calendar calendar = new GregorianCalendar(); Date date = new Date(); calendar.setTime(date);
        return calendar.getTime();
    }

    @Test
    public void deveCriarConta(){
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        Assert.assertEquals(nome, contaAlexandre.getNomeTitular());
        Assert.assertEquals(saldo, contaAlexandre.getSaldo(),0.0);
        Assert.assertEquals(cpf, contaAlexandre.getCpf());

    }

    @Test
    public void deveRealizarDeposito() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        contaAlexandre.depositar(6000);
        Assert.assertEquals(11000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(6000, contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
    }

    @Test
    public void deveRealizarSaque() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        contaAlexandre.sacar(4000);
        Assert.assertEquals(1000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(4000, contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
    }

    @Test
    public void deveRealizarTransferencia() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        String nomeTitularTransferencia = "Maiko";
        String cpfTitularTransferencia = "05198654706";
        contaAlexandre.transferir(4000, nomeTitularTransferencia, cpfTitularTransferencia);
        Assert.assertEquals(1000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(4000, contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
        Assert.assertEquals(nomeTitularTransferencia, contaAlexandre.getExtrato().getListTransacoes().get(0).getNomeTitularTransferencia());
        Assert.assertEquals(cpfTitularTransferencia, contaAlexandre.getExtrato().getListTransacoes().get(0).getCpfTitularTransferencia());
    }

    @Test
    public void deveJogarExeceptionComNomeTitularNulo(){
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        try {
            ContaCorrente contaAlexandre = new ContaCorrente(saldo, null, cpf);;
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "Nome do titular da conta não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComCpfTitularNulo(){
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        try {
            ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, null);;
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull){
            Assert.assertEquals( "CPF do titular da conta não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComCpfTitularTransferenciaNulo() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        String nomeTitularTransferencia = "Maiko";
        String cpfTitularTransferencia = "05198654706";
        try {
            contaAlexandre.transferir(4000, nomeTitularTransferencia, null);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull) {
            Assert.assertEquals("CPF do titular da conta de transferência não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComNomeTitularTransferenciaNulo() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, nome, cpf);
        String nomeTitularTransferencia = "Maiko";
        String cpfTitularTransferencia = "05198654706";
        try {
            contaAlexandre.transferir(4000,null, cpfTitularTransferencia);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull) {
            Assert.assertEquals("Nome do titular da conta de transferência não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }
}