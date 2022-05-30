package com.pfe.ecredit.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table
public class DemandeCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_DM", allocationSize = 1)
	private Integer idDemande;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sitFamiliale;
	private String typePiece;
	private String numPiece;
	private String numCompte;
	private Date dateCompte;
	private Integer nbreEcheance;
	private BigDecimal montant;
	private String unite;
	private LocalDate datePhase;
	private Integer idPhase;
	private Integer idTypeCredit;
	private String idUser;
	private String complement;
	private Integer gsm;
	private Integer idSimulation;
	@Transient
	private List<DemandeGarantie> garantie;

	@Transient
	private List<DemandePieceJointe> pieces;

	@Transient
	private String changerId;

}
