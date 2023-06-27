package com.servico.backservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Veiculo;
import com.servico.backservico.service.VeiculoService;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;
	
	@PostMapping("/inserir")
	public Veiculo salvar(@RequestBody Veiculo veiculo) {
		return veiculoService.salvar(veiculo);
	}
}
