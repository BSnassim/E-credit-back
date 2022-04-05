/**
 * 
 */
package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ecredit.domain.TypeDocuments;
import com.pfe.ecredit.repositories.TypeDocumentsRepository;

/**
 * @author Nassim.BenSalah
 *
 */
public class TypeDocumentsServiceImpl implements TypeDocumentsService {

	@Autowired
	private TypeDocumentsRepository repo;

	@Override
	public List<TypeDocuments> findAllDocuments() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public TypeDocuments findDocument(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}
}
