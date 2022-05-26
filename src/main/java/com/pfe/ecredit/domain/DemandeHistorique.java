package com.pfe.ecredit.domain;

import java.time.LocalDateTime;

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
public class DemandeHistorique {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_HIS", allocationSize = 1)
	private Integer idTrt;
	private Integer idPhase;
	private LocalDateTime datePhase;
	private Integer idDemande;
	private String userId;

}
