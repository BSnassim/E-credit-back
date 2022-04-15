package com.pfe.ecredit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class SiAgence {
	
	@Id
	private Integer idAgence;
	private String NomAgence;

}
