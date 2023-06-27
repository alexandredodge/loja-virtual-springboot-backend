package com.servico.backservico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.service.ServicoService;

@RestController
@RequestMapping("/api/servico")
@CrossOrigin("http://localhost:3000")
public class ServicoController {

	//Não estou utilizando diretamente a classe do repository e sim a classe intermediaria de serviço "ServicoService"
	@Autowired
	private ServicoService servicoService;
	
	@GetMapping("/")
	
	public List<Servico> buscarTodos(){
		return servicoService.buscarTodos();
	}
	
	@GetMapping("/pagamentoPendente")
	public List<Servico> buscarServicosPagamentoPendente(){
		return servicoService.buscarServicosPagamentoPendente();
	}
	
	@GetMapping("/pagamentoCancelado")
	public List<Servico> buscarServicosCancelados(){
		return servicoService.buscarServicosCancelados();
	}
	
	@PostMapping("/")
	public ResponseEntity<Servico> inserir(@RequestBody Servico servico) {
		return new ResponseEntity<Servico>(servicoService.salvarOuAlterar(servico,1),HttpStatus.CREATED); 
	}
	
	@PutMapping("/")
	public ResponseEntity<Servico> alterar(@RequestBody Servico servico) {
		return new ResponseEntity<Servico>(servicoService.salvarOuAlterar(servico,2),HttpStatus.OK); 
	}
		
	@DeleteMapping("/{id}")
	public Servico excluir(@PathVariable Long id) {
		Servico retorno = servicoService.excluir(id); 
		return ResponseEntity.ok(retorno).getBody();
	}
	
	@GetMapping("/cancelar/{id}")
	public ResponseEntity<Servico> cancelarServico(@PathVariable Long id){
		return new ResponseEntity<Servico>(servicoService.cancelarServico(id),HttpStatus.OK);
	}

}
