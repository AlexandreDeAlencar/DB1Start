package com.db1.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.demo.domain.entity.Estado;
import com.db1.demo.repository.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;

	public Estado criar(String nome) {
		Estado estado = new Estado(nome);
		return estadoRepository.save(estado);
		
	}
	
	
	
}
