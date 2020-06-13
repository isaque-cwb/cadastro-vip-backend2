package com.isaqueLourenco.cadastroVip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaqueLourenco.cadastroVip.domain.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
