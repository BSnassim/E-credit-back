package com.pfe.ecredit.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_USER", allocationSize = 1)
	private Integer id;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private Integer tel;
	private Date dateNais;
	
	@ManyToOne
	@JoinColumn(name="profil_id", referencedColumnName = "id")
	private Profil profil;

}
