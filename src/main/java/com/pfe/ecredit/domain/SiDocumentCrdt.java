package com.pfe.ecredit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.pfe.ecredit.domain.SiDocumentCrdt.SiDocumentCrdtId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SI_DOCUMENT_CRD")
@IdClass(SiDocumentCrdtId.class)
public class SiDocumentCrdt {

	@Id
	private int codeDocument;
	@Id
	private Long codeCredit;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class SiDocumentCrdtId implements Serializable {
		private int codeDocument;
		private Long codeCredit;
	}

}
