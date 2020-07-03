package com.isaqueLourenco.cadastroVip.dto;

import java.io.Serializable;

import com.isaqueLourenco.cadastroVip.domain.Carro;

public class CarroDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private Integer ano;
	private String parceiro;
	
	public CarroDTO() {}
	
	public CarroDTO(Carro obj) {
		id = obj.getId();
		marca = obj.getMarca();
		modelo = obj.getModelo();
		cor = obj.getCor();
		placa = obj.getPlaca();
		ano = obj.getAno();
		parceiro = obj.getParceiro();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getParceiro() {
		return parceiro;
	}

	public void setParceiro(String parceiro) {
		this.parceiro = parceiro;
	}

	


}
