package com.servico.backservico.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "fabricante")
@Data
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fabricante")
	private Long idFabricante;
	
	private String nome;
	
	@OneToMany(mappedBy = "fabricante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Veiculo> veiculos;
}
