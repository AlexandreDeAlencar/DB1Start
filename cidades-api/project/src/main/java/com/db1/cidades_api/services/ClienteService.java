package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.domain.entity.Conta;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criar(String nome, String cpf, String telefone) {
        Cliente cliente = new Cliente(nome,cpf, telefone);
        return clienteRepository.save(cliente);
    }

    public void deletarPorNome(String nome) {
        clienteRepository.delete(clienteRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado"))
        );
    }

    public void deletarPorId(Long id) {
        clienteRepository.delete(clienteRepository.findById(id).orElseThrow(
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

    public List<Cliente> buscarTodosPorNome(String nome){
        List<Cliente> cliente = new ArrayList<>();
        cliente = clienteRepository.findAllByNome(nome);
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

    public Cliente atualizar(Long clienteId, String novoNome, String cpf, String telefone) {
        Cliente cliente = buscarPorId(clienteId);
        cliente.setNome(novoNome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        return clienteRepository.save(cliente);
    }

}
