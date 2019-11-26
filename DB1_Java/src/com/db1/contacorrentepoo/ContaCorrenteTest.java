package com.db1.contacorrentepoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ContaCorrenteTest {

    @Test
    public void deveMostrarExtrato() {

        Date datainicial;
        Date datafinal;
        datainicial = dataAtual();
        Saque saque1 = new Saque(1000);
        Deposito deposito1 = new Deposito(5000);
        Deposito deposito2 = new Deposito(400);
        ArrayList<Operacao> operacoes = new ArrayList<>(
                Arrays.asList(deposito1, deposito2, saque1));
        Extrato extrato1 = new Extrato(operacoes);
        int saldo1 = 5000;
        String nome1 = "Alexandre";
        String cpf1 = "07193849905";
        Cliente alexandre = new Cliente(nome1, cpf1);
        String numero = "0516843";
        String agencia = "56";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo1, numero, agencia, alexandre);
        datafinal = dataAtual();
        contaAlexandre.depositar(400);
        contaAlexandre.sacar(1000);
        Assert.assertEquals(extrato1.saldoExtrato(),
                contaAlexandre.getExtrato(datainicial, datafinal).saldoExtrato(), 0.0);
        Assert.assertEquals(extrato1.getListaDeOperacoes().get(0).getValorOperacao(),
                contaAlexandre.getExtrato(datainicial, datafinal).getListaDeOperacoes().get(0).getValorOperacao(), 0.0);
    }


    public static Date dataAtual() {
        Calendar calendar = new GregorianCalendar();
        Date date = new Date();
        calendar.setTime(date);
        return calendar.getTime();
    }

    @Test
    public void deveCriarConta() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        Cliente alexandre = new Cliente(nome, cpf);
        String numero = "0516843";
        String agencia = "56";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, numero, agencia, alexandre);
        Assert.assertEquals(nome, contaAlexandre.getCliente().getNomeTitular());
        Assert.assertEquals(saldo, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(cpf, contaAlexandre.getCliente().getCpf());
        Assert.assertEquals(numero, contaAlexandre.getNumero());
        Assert.assertEquals(agencia, contaAlexandre.getAgencia());
    }

    @Test
    public void deveRealizarDeposito() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        Cliente alexandre = new Cliente(nome, cpf);
        String numero = "0516843";
        String agencia = "56";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, numero, agencia, alexandre);
        contaAlexandre.depositar(6000);
        Assert.assertEquals(11000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(6000,
                contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
    }

    @Test
    public void deveRealizarSaque() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        Cliente alexandre = new Cliente(nome, cpf);
        String numero = "0516843";
        String agencia = "56";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo, numero, agencia, alexandre);
        contaAlexandre.sacar(4000);
        Assert.assertEquals(1000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(4000, contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
    }

    @Test
    public void deveRealizarTransferencia() {
        double saldo1 = 5000;
        String nome1 = "Alexandre";
        String cpf1 = "07193849905";
        Cliente alexandre = new Cliente(nome1, cpf1);
        double saldo2 = 42300;
        String nome2 = "Maiko";
        String cpf2 = "07156845375";
        Cliente maiko = new Cliente(nome2, cpf2);
        String numero1 = "0516843";
        String numero2 = "0558434";
        String agencia = "56";
        ContaCorrente contaAlexandre = new ContaCorrente(saldo1, numero1, agencia, alexandre);
        ContaCorrente contaMaiko = new ContaCorrente(saldo2, numero2, agencia, maiko);
        contaAlexandre.transferir(4000, contaMaiko);
        Assert.assertEquals(1000, contaAlexandre.getSaldo(), 0.0);
        Assert.assertEquals(-4000, contaAlexandre.getExtrato().getListaDeOperacoes().get(1).getValorOperacao(), 0.0);
        Assert.assertEquals(contaMaiko.getCliente().getNomeTitular(),
                contaAlexandre.getExtrato().getListTransacoes().get(0).getContaCorrenteTransferencia().getCliente().getNomeTitular());
        Assert.assertEquals(contaAlexandre.getCliente().getNomeTitular(),
                contaMaiko.getExtrato().getListTransacoes().get(0).getContaCorrenteTransferencia().getCliente().getNomeTitular());
    }

    @Test
    public void deveJogarExeceptionComNomeTitularNulo() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        try {
            Cliente alexandre = new Cliente(null, cpf);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull) {
            Assert.assertEquals("Nome do titular da conta não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }

    @Test
    public void deveJogarExeceptionComCpfTitularNulo() {
        int saldo = 5000;
        String nome = "Alexandre";
        String cpf = "07193849905";
        try {
            Cliente alexandre = new Cliente(nome, null);
        } catch (com.db1.contacorrentepoo.CampoNaoPodeSerNull naoPodeSerNull) {
            Assert.assertEquals("CPF do titular da conta não pode ser nulo", naoPodeSerNull.getMessage());
        }
    }
}

