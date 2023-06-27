package com.servico.backservico.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.servico.backservico.entity.Servico;
import com.servico.backservico.repository.ServicoRepository;
import com.servico.backservico.utils.ValidarStatus;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;
	 
	
	//Método para listar todos os serviço
	public List<Servico> buscarTodos(){
		return servicoRepository.findAll();
	}

	
	//Método para cadastrar ou alterar um serviço
	public Servico salvarOuAlterar(Servico servico, Integer acao) {
		
		Servico servicoRetorno;
		//Validando/setando o status
		servico.setStatus(new ValidarStatus().validarStatus(servico));
				
		if(acao.equals(1)) {
			servicoRetorno = servicoRepository.save(servico);
		}else {
			servicoRetorno = servicoRepository.saveAndFlush(servico);
		}
		return servicoRetorno;
	}
	
	
	//Método para deletar um serviço
	public Servico excluir(Long id) {
		Servico objSelecionado = servicoRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Serviço não encontrado.") );
		servicoRepository.delete(objSelecionado);
		return objSelecionado;
		
	}
		
	//Método para buscar um serviço com o pagamento pendente
	public List<Servico> buscarServicosPagamentoPendente(){
		return servicoRepository.buscarServicosPagamentoPendente();
	}
	
	//Método para buscar um serviço cancelado
	public List<Servico> buscarServicosCancelados(){
		return servicoRepository.buscarServicosCancelados();
	}
	
	//Método para cancelar um serviço
	public Servico cancelarServico(Long id) {
		Servico obj = servicoRepository.findById(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Não encontrado.") );
		
		if(!obj.getStatus().equals("cancelado")) {
			obj.setStatus("cancelado");
			servicoRepository.saveAndFlush(obj);
		}
		return obj;
	}
	
		
}
