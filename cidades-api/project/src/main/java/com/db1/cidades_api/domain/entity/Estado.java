package com.db1.cidades_api.domain.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@Column(name = "nome", nullable = false)
	 private String nome;
	
	@OneToMany(mappedBy = "uf", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cidade> cidades;


	public Estado() {}

	public Estado(String nome) {
		this.nome = nome;
		this.cidades = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
