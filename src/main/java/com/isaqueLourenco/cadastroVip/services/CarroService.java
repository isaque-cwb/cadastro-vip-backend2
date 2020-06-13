package com.isaqueLourenco.cadastroVip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Carro;
import com.isaqueLourenco.cadastroVip.repositories.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	
	public Carro buscar(Integer id) {
		
		Optional<Carro> obj = carroRepository.findById(id);
		return obj.orElse(null);
	}
}
