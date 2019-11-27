package com.db1.cidades_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public void deletar(String nome) {
		estadoRepository.delete(estadoRepository.findByNome("Paraná").orElseThrow(
				() -> new RuntimeException( "Não foi encontrado"))
		);
	}

	public Estado findByNome(String nome){
		Estado estado = new Estado();
		estado = estadoRepository.findByNome("Paraná").orElseThrow(
				() -> new RuntimeException( "Não foi encontrado")
		);
		return estado;
	}



}
