package com.pfe.ecredit.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Profil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_PROFIL", allocationSize = 1)
	private Integer id;
	private String libelle;
	@JoinTable(
			name="Profil_Habilitation",
			joinColumns = @JoinColumn(
					name = "CODE_PROFIL",
					referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "CODE_HABILITATION",
					referencedColumnName = "id"))
	@ManyToMany
	private List<Habilitation> habilitations;
	
	
}
