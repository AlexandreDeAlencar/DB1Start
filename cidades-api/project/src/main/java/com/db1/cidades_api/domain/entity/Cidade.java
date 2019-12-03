package com.db1.cidades_api.domain.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", length = 60)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
	private Estado uf;

	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Agencia> agencias;

	public Cidade() {
	}

	public Cidade( String nome, Estado uf) {
		this.id = id;
		this.uf = uf;
		this.agencias = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Estado getUf() {
		return uf;
	}

	public List<Agencia> getAgencias() {
		return agencias;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setUf(Estado uf) {
		this.uf = uf;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}
}
