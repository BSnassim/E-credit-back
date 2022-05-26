package com.pfe.ecredit.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Utilisateur {
	@Id
	private String id;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private Integer tel;
	private Date dateNais;
	
	@ManyToOne
	@JoinColumn(name="profil_id", referencedColumnName = "id")
	private Profil profil;

	@ManyToOne
	@JoinColumn(name="agence_id", referencedColumnName = "idAgence")
	private SiAgence agence;
}
