package com.isaqueLourenco.cadastroVip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Parceiro;
import com.isaqueLourenco.cadastroVip.repositories.ParceiroRepository;

@Service
public class ParceiroService {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	
	public Parceiro buscar(Integer id) {
		
		Optional<Parceiro> obj = parceiroRepository.findById(id);
		return obj.orElse(null);
	}
}
