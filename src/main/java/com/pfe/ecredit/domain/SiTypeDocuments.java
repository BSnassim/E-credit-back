package com.pfe.ecredit.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class SiTypeDocuments {
	
	@Id
	private Integer idDoc;
	private String libDoc;
	
	

}

