package com.isaqueLourenco.cadastroVip.dto;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import com.isaqueLourenco.cadastroVip.domain.Parceiro;




public class ParceiroDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Length(min = 5, max = 50, message = "O tamanho deve ser entre 5 e 50 caracteres!")
	private String nome;
	@NotEmpty(message = "Preenchimento Obrigatório!")
	@Email
	private String email;
	@NotEmpty(message = "Preenchimento Obrigatório e com (DDD)!")
	@Pattern(regexp="\\(\\d{2}\\)\\d{5}-\\d{4}", message = "Deve corresponder ao formato: (XX)XXXXX-XXXX.")//mascara do bean validation para telefone.
	private String telefone;
	
	public ParceiroDTO() {}
	
	public ParceiroDTO(Parceiro obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		telefone = obj.getTelefone();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

		
}
