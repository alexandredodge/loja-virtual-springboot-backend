package com.servico.backservico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Fabricante;
import com.servico.backservico.service.FabricanteService;

@RestController
@RequestMapping("/api/fabricante")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;

	@PostMapping("/inserir")
	public Fabricante salvar(@RequestBody Fabricante fabricante) {
		return fabricanteService.salvar(fabricante);
	}
	
}
