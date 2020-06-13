package com.isaqueLourenco.cadastroVip;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.isaqueLourenco.cadastroVip.domain.Carro;
import com.isaqueLourenco.cadastroVip.domain.Cidade;
import com.isaqueLourenco.cadastroVip.domain.Endereco;
import com.isaqueLourenco.cadastroVip.domain.Estado;
import com.isaqueLourenco.cadastroVip.domain.Indicado;
import com.isaqueLourenco.cadastroVip.domain.Parceiro;
import com.isaqueLourenco.cadastroVip.repositories.CarroRepository;
import com.isaqueLourenco.cadastroVip.repositories.CidadeRepository;
import com.isaqueLourenco.cadastroVip.repositories.EnderecoRepository;
import com.isaqueLourenco.cadastroVip.repositories.EstadoRepository;
import com.isaqueLourenco.cadastroVip.repositories.IndicadoRepository;
import com.isaqueLourenco.cadastroVip.repositories.ParceiroRepository;

@SpringBootApplication
public class CadastroVipApplication implements CommandLineRunner {
	
	@Autowired
	private ParceiroRepository parceiroRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
		
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private IndicadoRepository indicadoRepository;


	public static void main(String[] args) {
		SpringApplication.run(CadastroVipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Parceiro par1 = new Parceiro(null, "Isaque Lourenço", "isaque@gmail.com", " 41-99565-5887");
		Parceiro par2 = new Parceiro(null, "Sarah Lourenço", "sarah@gmail.com", "41-99904-4099");
		
		Carro car1 = new Carro(null, "Fiat", "Palio", "Preto", "AWL-8708", 2013, par1.getNome());
		Carro car2 = new Carro(null, "Chevrolet", "Onix Plus", "Prata", "AYT-9608", 2019, par2.getNome());
		
		Endereco end1 = new Endereco(null, "Epaminondas Santos", "2723", "casa 4 ", "Bairro Alto", "82.820-090");
		Endereco end2 = new Endereco(null, "Av. Paraná", "2563", "apto 6 ", "Cabral", "82.850-080");
		
		Estado est1 = new Estado(null, "Paraná");
		
		Cidade cid1 = new Cidade(null, "Curitiba");
		Cidade cid2 = new Cidade(null, "Campina Grande do Sul");
		
		Indicado ind1 = new Indicado(null, "Marcos", "41-65322-5623");
		Indicado ind2 = new Indicado(null, "Norberto", "41-96356-8546");
				
		
		par1.getCarro().addAll(Arrays.asList(car1));
		par2.getCarro().addAll(Arrays.asList(car2));
		
		car1.getParceiros().addAll(Arrays.asList(par1));
		car2.getParceiros().addAll(Arrays.asList(par2));
		
		par1.getEndereco().addAll(Arrays.asList(end1));
		par2.getEndereco().addAll(Arrays.asList(end2));
		
		end1.getParceiro().addAll(Arrays.asList(par1));
		end2.getParceiro().addAll(Arrays.asList(par2));
		
		cid1.getEndereco().addAll(Arrays.asList(end1));
		cid2.getEndereco().addAll(Arrays.asList(end2));
		
		end1.getCidade().addAll(Arrays.asList(cid1));
		end2.getCidade().addAll(Arrays.asList(cid2));
		
		est1.getCidade().addAll(Arrays.asList(cid1, cid2));
		
		ind1.getParceiro().addAll(Arrays.asList(par1));
		ind2.getParceiro().addAll(Arrays.asList(par2));
		
		par1.getIndicado().addAll(Arrays.asList(ind1));
		par2.getIndicado().addAll(Arrays.asList(ind2));
		
	
		parceiroRepository.saveAll(Arrays.asList(par1, par2));
		carroRepository.saveAll(Arrays.asList(car1, car2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		estadoRepository.save(est1);
		indicadoRepository.saveAll(Arrays.asList(ind1, ind2));
	}

}
