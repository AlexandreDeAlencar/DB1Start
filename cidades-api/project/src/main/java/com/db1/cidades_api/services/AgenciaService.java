package com.db1.cidades_api.services;

import com.db1.cidades_api.domain.entity.Agencia;
import com.db1.cidades_api.domain.entity.Cidade;
import com.db1.cidades_api.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia criar(String numero, Cidade cidade) {
        Agencia agencia = new Agencia(numero, cidade);
        return agenciaRepository.save(agencia);
    }

    public void Delete(Agencia agencia) {
        agenciaRepository.delete(agencia);
    }

}
