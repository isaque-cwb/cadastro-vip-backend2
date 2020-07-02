package com.isaqueLourenco.cadastroVip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Parceiro;
import com.isaqueLourenco.cadastroVip.repositories.ParceiroRepository;
import com.isaqueLourenco.cadastroVip.services.exceptions.ObjectNotFoundException;

@Service
public class ParceiroService {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	
	public Parceiro find(Integer id) {
		Optional<Parceiro> obj = parceiroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Parceiro.class.getName()));
	}


	public Parceiro insert(Parceiro obj) {
		obj.setId(null);
		return parceiroRepository.save(obj);
	}


	public Parceiro update(Parceiro obj) {
		find(obj.getId());
		return parceiroRepository.save(obj);
	}


	public void delete(Integer id) {
		find(id);
		parceiroRepository.deleteById(id);
	}
	
	
}
