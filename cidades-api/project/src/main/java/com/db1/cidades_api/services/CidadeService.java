package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade criar(String nome, Estado estado) {
        Cidade cidade = new Cidade(nome, estado);
        return cidadeRepository.save(cidade);
    }

    public void deletarPorNome(String nome) {
        cidadeRepository.delete(cidadeRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado"))
        );
    }

    public Cidade buscarPorNome(String nome){
        Cidade cidade = new Cidade();
        cidade = cidadeRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException( "Não foi encontrado")
        );
        return cidade;
    }
    public Cidade atualizar(Long cidadeId, String novoNome) {
        Cidade cidade = buscarPorId(cidadeId);
        cidade.setNome(novoNome);
        return cidadeRepository.save(cidade);
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }

    public List<Cidade> buscarTodosPeloIdDoEstado(Long estadoId) {
        return cidadeRepository.findByUfId(estadoId);
    }

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
    }

    public void deletarPorId(Long id) {
        cidadeRepository.deleteById(id);
    }

    public void deletarTodos() {
        cidadeRepository.deleteAll();
    }

}
