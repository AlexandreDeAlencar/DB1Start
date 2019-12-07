package com.db1.cidades_api.services;

import com.db1.cidades_api.requestdto.EstadoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.cidades_api.domain.entity.Estado;
import com.db1.cidades_api.repository.EstadoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
	}

	public void deletarPorNome(String nome) {
		Estado estado = new Estado();
		estado = estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException( "Não foi encontrado")
		);
		estadoRepository.delete(estado);
	}

	public List<Estado> buscarTodosPorNome(String nome){
		List<Estado> estados = new ArrayList<>();
		estados = estadoRepository.findAllByNome(nome);
		return estados;
	}

	public Estado buscarPorNome(String nome){
		Estado estado = new Estado();
		estado = estadoRepository.findByNome(nome).orElseThrow(
				() -> new RuntimeException( "Não foi encontrado")
		);
		return estado;
	}

	public Estado atualizar(Long id, EstadoRequestDTO estadoRequestDTO) {
		Estado estado = buscarPorId(id);
		estado.setNome(estadoRequestDTO.getNome());
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
