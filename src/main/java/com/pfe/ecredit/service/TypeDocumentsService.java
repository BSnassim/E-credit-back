package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.TypeDocuments;

public interface TypeDocumentsService {
	
	public List<TypeDocuments> findAllDocuments();
	public TypeDocuments findDocument(Integer id);

}
