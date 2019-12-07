package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia criar(String numero, Cidade cidade) {
        Agencia agencia = new Agencia(numero, cidade);
        return agenciaRepository.save(agencia);
    }

    public void deletarPorNumero(String numero) {
        agenciaRepository.delete(agenciaRepository.findByNumero(numero).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado"))
        );
    }

    public void deletarPorId(Long id) {
        agenciaRepository.delete(agenciaRepository.findById(id).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado"))
        );
    }

    public Agencia buscarPorNome(String numero){
        Agencia agencia = new Agencia();
        agencia = agenciaRepository.findByNumero(numero).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado")
        );
        return agencia;
    }

    public List<Agencia> buscarTodosPorNumero(String numero){
        List<Agencia> agencias = new ArrayList<>();
        agencias = agenciaRepository.findaAllByNumero(numero);
        return agencias;
    }

    public List<Agencia> buscarTodos(){
        return agenciaRepository.findAll();
    }
    public Agencia buscarPorId(Long id) {
        return agenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Agência não encontrada"));
    }

    public List<Agencia> buscarTodasPeloIdDaCidade(Long cidadeId) {
        return agenciaRepository.findByCidadeId(cidadeId);
    }

    public void deletarTodos() {
        agenciaRepository.deleteAll();
    }

    public Agencia atualizar(Long agenciaId, String novoNumero, Cidade cidade) {
        Agencia agencia = buscarPorId(agenciaId);
        agencia.setNumero(novoNumero);
        agencia.setCidade(cidade);
        return agenciaRepository.save(agencia);
    }

}
