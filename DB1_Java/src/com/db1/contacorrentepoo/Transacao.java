package com.db1.contacorrentepoo;

public class Transacao extends Operacao {
    private ContaCorrente contaCorrenteTransferencia;

    public Transacao(double valorOperacao,ContaCorrente contaCorrenteTransferencia) {
        super(valorOperacao);
        if (contaCorrenteTransferencia == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("A conta corrente de transferência deve conter um objeto válido");
        }
        this.contaCorrenteTransferencia=contaCorrenteTransferencia;
    }

    public ContaCorrente getContaCorrenteTransferencia() {
        return contaCorrenteTransferencia;
    }

    public void setContaCorrenteTransferencia(ContaCorrente contaCorrenteTransferencia) {
        this.contaCorrenteTransferencia = contaCorrenteTransferencia;
    }
}
