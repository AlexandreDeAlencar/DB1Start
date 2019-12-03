package com.db1.cidades_api.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.EstadoRepository;

import java.util.List;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(@JsonProperty String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public void deletarPorNome(@JsonProperty String nome) {
		Estado estado = new Estado();
		estado = estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException( "Não foi encontrado")
		);
		estadoRepository.delete(estado);
	}

	public Estado buscarPorNome( @JsonProperty String nome){
		Estado estado = new Estado();
		estado = estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException( "Não foi encontrado")
		);
		return estado;
	}

	public Estado atualizar(Long id, @JsonProperty String novoNome) {
		Estado estado = buscarPorId(id);
		estado.setNome(novoNome);
		return estadoRepository.save(estado);
	}

	public Estado buscarPorId(Long id) {
		return estadoRepository.findById(id).orElseThrow(() ->
				new RuntimeException("Estado não encontrado"));
	}

	public List<Estado> buscarTodos() {
		return estadoRepository.findAll();
	}

	public void deletarPorId(Long id) {
		estadoRepository.deleteById(id);
	}

	public void deletarTodos() {
		estadoRepository.deleteAll();
	}
}
