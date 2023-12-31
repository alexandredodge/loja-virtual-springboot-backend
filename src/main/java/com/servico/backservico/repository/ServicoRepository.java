package com.servico.backservico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.servico.backservico.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico,Long>{

	@Query("SELECT s FROM Servico s WHERE s.valorPago is null or s.valorPago = 0")
	List<Servico> buscarServicosPagamentoPendente();
	
	
	@Query("SELECT s FROM Servico s WHERE s.status = 'cancelado'")
	List<Servico> buscarServicosCancelados();
}
