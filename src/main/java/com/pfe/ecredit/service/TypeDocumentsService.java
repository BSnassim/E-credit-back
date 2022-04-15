package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiTypeDocuments;

public interface TypeDocumentsService {
	
	public List<SiTypeDocuments> findAllDocuments();
	public SiTypeDocuments findDocument(Integer id);
	public List<SiTypeDocuments> findDocumentsByCredit(Integer id);

}
