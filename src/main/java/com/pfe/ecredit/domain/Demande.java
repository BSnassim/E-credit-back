package com.pfe.ecredit.domain;

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
public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_DM", allocationSize = 1)
	private Integer id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sitFamiliale;
	private Integer numCin;
	private Integer numCompte;
	private Date dateCompte;
	
	@OneToMany
	@JoinColumn(name="demande_id", referencedColumnName = "id")
	private List<Garantie> garanties;
	
	@OneToMany
	@JoinColumn(name="demande_id", referencedColumnName = "id")
	private List<PiecesJointes> piecesJointes;
	
	@ManyToOne
	@JoinColumn(name="phase_id", referencedColumnName = "id")
	private Phase phase;
}
