package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade criar(String nome, Estado estado) {
        Cidade cidade = new Cidade(nome, estado);
        return cidadeRepository.save(cidade);
    }

    public void Delete(Cidade cidade) {
       cidadeRepository.delete(cidade);
    }

}
