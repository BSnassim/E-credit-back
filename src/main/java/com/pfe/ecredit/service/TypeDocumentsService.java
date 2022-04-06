package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiTypeDocuments;

public interface TypeDocumentsService {
	
	public List<SiTypeDocuments> findAllDocuments();
	public SiTypeDocuments findDocument(Long id);
	public List<SiTypeDocuments> findDocumentsByCredit(Long id);

}
