package com.isaqueLourenco.cadastroVip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Carro;
import com.isaqueLourenco.cadastroVip.repositories.CarroRepository;
import com.isaqueLourenco.cadastroVip.services.exceptions.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
		
	
	public Carro find(Integer id) {
		Optional<Carro> obj = carroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Carro.class.getName()));
	}


	public Carro inset(Carro obj) {
		obj.setId(null);
		return carroRepository.save(obj);
	}
	
	public Carro update(Carro obj) {
		find(obj.getId());
		return carroRepository.save(obj);
	}


	public void delete(Integer id) {
		find(id);
		carroRepository.deleteById(id);
		
	}
	
	public List<Carro> findAll() {
		return carroRepository.findAll();
	}
	
	
	
}
