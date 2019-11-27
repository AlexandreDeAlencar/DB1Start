package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(String nome, String cpf) {
        Cliente cliente = new Cliente(nome,cpf);
        return clienteRepository.save(cliente);
    }

    public void Delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

}
