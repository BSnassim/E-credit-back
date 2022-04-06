package com.pfe.ecredit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class SiNatureGarantie {

	@Id
	private Integer idNature;
	private String libelleNature;

}
