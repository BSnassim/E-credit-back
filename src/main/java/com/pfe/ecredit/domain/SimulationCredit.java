package com.pfe.ecredit.domain;

import java.math.BigDecimal;
import java.util.Date;

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
public class SimulationCredit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_SIM", allocationSize = 1)
	private Integer idSim;
	private Integer idUser;
	private String nom;
	private String prenom;
	private String typePiece;
	private String numPiece;
	private String numCompte;
	private Date dateCompte;
	private Date dateNaissance;
	private String sitFamiliale;
	private String sitMedicale;
	private String sitProfessionnel;
	private Integer gsm;
	private BigDecimal montant;
	private Integer nbreEcheance;
	private String unite;
	private Integer idTypeCredit;
	private BigDecimal salaire;
	private BigDecimal autreRevenu;
	private String sitLogement;
	private String resultat;
}
