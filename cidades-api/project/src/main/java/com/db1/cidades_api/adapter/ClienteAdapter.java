package com.db1.cidades_api.adapter;

import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.responsedto.ClienteResponseDTO;

public class ClienteAdapter {

    public static ClienteResponseDTO transformarEntidadeEmDto(Cliente cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setNome(cliente.getNome());
        clienteResponseDTO.setCpf(cliente.getCpf());
        clienteResponseDTO.setTelefone(cliente.getTelefone());
        clienteResponseDTO.setConta(cliente.getConta());
        return clienteResponseDTO;
    }
}
