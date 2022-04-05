package com.pfe.ecredit.domain;

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
public class Garantie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_GR", allocationSize = 1)
	private Integer id;
	private Float montant;
	
	@ManyToOne
	@JoinColumn(name="nature_garantie_id", referencedColumnName = "id")
	private NatureGarantie natureGarantie;
	
	@ManyToOne
	@JoinColumn(name="type_garantie_id", referencedColumnName = "id")
	private TypeGarantie typeGarantie;
	

}
