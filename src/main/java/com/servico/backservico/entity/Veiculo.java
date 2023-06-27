package com.servico.backservico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "veiculo")
@Data
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_veiculo")
	private Long idVeiculo;
	
	@Column(name = "nome_modelo")
	private String modelo;
	
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	private Fabricante fabricante;
}
