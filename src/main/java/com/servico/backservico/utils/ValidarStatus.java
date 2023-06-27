package com.servico.backservico.utils;

import com.servico.backservico.entity.Servico;

public class ValidarStatus {

	public String validarStatus(Servico servico) {
		String status = "";
		if(servico.getDataPagamento() == null || servico.getValorPago() == 0 || servico.getValorPago() == null) {
			status = "pendente";
		}else {
			status = "realizado";
		}
		return status;
	}
		
}
