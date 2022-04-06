package com.pfe.ecredit.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class DemandeCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_DM", allocationSize = 1)
	private Long idDemande;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sitFamiliale;
	private String typePiece;
	private Integer numPiece;
	private Integer numCompte;
	private Date dateCompte;
	private Integer nbreEcheance;
	private BigDecimal montant;
	private String unite;
	private Date datePhase;
	private Integer idPhase;
	private Integer idTypeCredit;

}
