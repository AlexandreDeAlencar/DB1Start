package com.db1.contacorrentepoo;

public class Transacao extends Operacao {
    private String nomeTitularTransferencia;
    private String cpfTitularTransferencia;

    public Transacao(double valorOperacao, String nomeTitularTransferencia, String cpfTitularTransferencia) {
        super(valorOperacao);
        if (nomeTitularTransferencia == null){
            throw new com.db1.contacorrentepoo.CampoNaoPodeSerNull("Nome do titular da conta de transferência não pode ser nulo");
        }
        if (cpfTitularTransferencia == null){
            throw new CampoNaoPodeSerNull("CPF do titular da conta de transferência não pode ser nulo");
        }
        this.nomeTitularTransferencia = nomeTitularTransferencia;
        this.cpfTitularTransferencia = cpfTitularTransferencia;
    }

    public String getNomeTitularTransferencia() {
        return nomeTitularTransferencia;
    }

    public void setNomeTitularTransferencia(String nomeTitularTransferencia) {
        this.nomeTitularTransferencia = nomeTitularTransferencia;
    }

    public String getCpfTitularTransferencia() {
        return cpfTitularTransferencia;
    }

    public void setCpfTitularTransferencia(String cpfTitularTransferencia) {
        this.cpfTitularTransferencia = cpfTitularTransferencia;
    }
}
