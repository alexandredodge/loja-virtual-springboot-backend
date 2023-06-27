package com.servico.backservico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servico.backservico.entity.Fabricante;
import com.servico.backservico.repository.FabricanteRepository;

@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;

	public Fabricante salvar(Fabricante fabricante) {
		return fabricanteRepository.save(fabricante);
	}
}
