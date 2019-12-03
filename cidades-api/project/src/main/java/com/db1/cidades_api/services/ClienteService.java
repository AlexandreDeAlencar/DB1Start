package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(String nome, String cpf) {
        Cliente cliente = new Cliente(nome,cpf);
        return clienteRepository.save(cliente);
    }

    public void deletarPorNome(String nome) {
        clienteRepository.delete(clienteRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado"))
        );
    }

    public Cliente BuscarPorNome(String nome){
        Cliente cliente = new Cliente();
        cliente = clienteRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado")
        );
        return cliente;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("CLiente não encontrado"));
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void deletarTodos() {
        clienteRepository.deleteAll();
    }
}
