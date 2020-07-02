package com.isaqueLourenco.cadastroVip.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Indicado;
import com.isaqueLourenco.cadastroVip.repositories.IndicadoRepository;
import com.isaqueLourenco.cadastroVip.services.exceptions.ObjectNotFoundException;

@Service
public class IndicadoService {
	
	@Autowired
	private IndicadoRepository indicadoRepository;

	
	public Indicado find(Integer id) {
		Optional<Indicado> obj = indicadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Indicado.class.getName()));
	}
	
	public Indicado insert(Indicado obj) {
		obj.setId(null);
		return indicadoRepository.save(obj);		
	}
	
	public Indicado update(Indicado obj) {
		find(obj.getId());
		return indicadoRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		indicadoRepository.deleteById(id);
	}
}
