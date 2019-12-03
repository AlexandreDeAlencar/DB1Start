package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cliente;
import com.db1.cidades_api.domain.entity.Conta;
import com.db1.cidades_api.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta criar(double saldo, Agencia agencia, Cliente cliente) {
        Conta conta = new Conta(saldo, agencia, cliente);
        return contaRepository.save(conta);
    }

    public List<Conta> buscarTodos(){
        return  contaRepository.findAll();
    }

    public Conta buscarPorId(Long id){
        return  contaRepository.findById(id).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado")
        );
    }

    public List<Conta> buscarTodosPorId(List<Long> ids){
        return  contaRepository.findAllById(ids);
    }

    public void deletarTodos() {
        contaRepository.deleteAll();
    }

    public void deletarTodasContasDaAgencia(Agencia agencia) {
        List<Conta> contasAgencia = new ArrayList<>();
        contasAgencia = contaRepository.findAllByAgencia(agencia);
        for (int i = 0; i < contasAgencia.size(); i++) {
            contaRepository.delete(contasAgencia.get(i));
        }
    }

    public void deletarTodasContasDoCliente(Cliente cliente) {
        List<Conta> contasCliente = new ArrayList<>();
        contasCliente = contaRepository.findAllByCliente(cliente);
        for (int i = 0; i < contasCliente.size(); i++) {
            contaRepository.delete(contasCliente.get(i));
        }
    }

    public Conta atualizar(Long id, double saldo, Agencia agencia, Cliente cliente) {
        Conta conta = buscarPorId(id);
        conta.setSaldo(saldo);
        conta.setAgencia(agencia);
        conta.setCliente(cliente);
        return contaRepository.save(conta);
    }

}
