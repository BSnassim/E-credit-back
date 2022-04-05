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
public class TypeCredit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_TC", allocationSize = 1)
	private Integer id;
	private String libCredit;
	
	@JoinTable(
			name="TypeCredit_TypeDocument",
			joinColumns = @JoinColumn(
					name = "CODE_CREDIT",
					referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "CODE_DOCUMENT",
					referencedColumnName = "id"))
	@ManyToMany
	private List<TypeDocuments> documents;
}
