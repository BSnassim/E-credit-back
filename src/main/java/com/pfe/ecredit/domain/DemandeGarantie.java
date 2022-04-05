package com.pfe.ecredit.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class DemandeGarantie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_GR", allocationSize = 1)
	private Integer idGarantieDde;
	private BigDecimal montant;
	private Integer idNatureGarantie;
	private Integer idTypeGrt;
	private Long idDemande;

}
