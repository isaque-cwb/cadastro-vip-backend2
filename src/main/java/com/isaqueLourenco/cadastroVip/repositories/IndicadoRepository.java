package com.isaqueLourenco.cadastroVip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isaqueLourenco.cadastroVip.domain.Indicado;

@Repository
public interface IndicadoRepository extends JpaRepository<Indicado, Integer> {

}
