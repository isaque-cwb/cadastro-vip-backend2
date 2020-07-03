package com.isaqueLourenco.cadastroVip.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.isaqueLourenco.cadastroVip.domain.Parceiro;
import com.isaqueLourenco.cadastroVip.dto.ParceiroDTO;
import com.isaqueLourenco.cadastroVip.repositories.ParceiroRepository;
import com.isaqueLourenco.cadastroVip.services.exceptions.DataIntegrityException;
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
		try {
			parceiroRepository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível DELETAR um parceiro que possui outros dados de cadastro!");
		}
		
	}


	public List<Parceiro> findAll() {
		return parceiroRepository.findAll();
	}
	
	public Page<Parceiro> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return parceiroRepository.findAll(pageRequest);
	}
	
	public Parceiro fromDTO(ParceiroDTO objDto) {
		return new Parceiro(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getTelefone());
	}
	
}
