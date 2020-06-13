package com.isaqueLourenco.cadastroVip.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToMany(mappedBy = "cidade")
	private List<Estado> estado = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "CIDADE_ENDERECO",
			joinColumns = @JoinColumn(name = "cidade_id"),
			inverseJoinColumns = @JoinColumn(name = "endereco_id")
			)
	private List<Endereco> endereco = new ArrayList<>();
	
	
	public Cidade () {}
	
	
	public Cidade(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cidade [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}


//	public List<Estado> getEstado() {
//		return estado;
//	}
//
//
//	public void setEstado(List<Estado> estado) {
//		this.estado = estado;
//	}


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public List<Estado> getEstado() {
		return estado;
	}


	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	
	

}
