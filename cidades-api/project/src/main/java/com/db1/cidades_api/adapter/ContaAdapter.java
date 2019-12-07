package com.db1.cidades_api.adapter;

import com.db1.cidades_api.domain.entity.Conta;
import com.db1.cidades_api.responsedto.ContaResponseDTO;

public class ContaAdapter {

    public static ContaResponseDTO transformarEntidadeEmDto(Conta conta) {
        ContaResponseDTO contaResponseDTO = new ContaResponseDTO();
        contaResponseDTO.setSaldo(conta.getSaldo());
        contaResponseDTO.setAgencia(conta.getAgencia());
        contaResponseDTO.setCliente(conta.getCliente());
        return contaResponseDTO;
    }

}
