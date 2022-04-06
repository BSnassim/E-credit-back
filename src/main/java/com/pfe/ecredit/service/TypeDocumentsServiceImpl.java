/**
 * 
 */
package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SiTypeDocuments;
import com.pfe.ecredit.repositories.SiTypeDocumentsRepository;


@Service
public class TypeDocumentsServiceImpl implements TypeDocumentsService {

	@Autowired
	private SiTypeDocumentsRepository repo;

	@Override
	public List<SiTypeDocuments> findAllDocuments() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public SiTypeDocuments findDocument(Long id) {
		return (repo.findById(id).isPresent()) ? repo.findById(id).get() : null;
	}

	@Override
	public List<SiTypeDocuments> findDocumentsByCredit(Long id) {
		return repo.findPieceByTypeCredit(id);
	}
}
