package com.isaqueLourenco.cadastroVip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Endereco;
import com.isaqueLourenco.cadastroVip.repositories.EnderecoRepository;
import com.isaqueLourenco.cadastroVip.services.exceptions.ObjectNotFoundException;


@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	public Endereco find(Integer id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}


	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return enderecoRepository.save(obj);
	}


	public Endereco update(Endereco obj) {
		find(obj.getId());
		return enderecoRepository.save(obj);
	}


	public void delete(Integer id) {
		find(id);
		enderecoRepository.deleteById(id);
		
	}
}
