package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SiTypeDocuments;
import com.pfe.ecredit.service.TypeDocumentsService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class TypeDocumentsEndpoint {

	@Autowired
	private TypeDocumentsService typeDocumentsService;

	@GetMapping("/documents")
	public List<SiTypeDocuments> findAllDocuments() {
		return typeDocumentsService.findAllDocuments();
	}

	@GetMapping("/documents/{id}")
	public SiTypeDocuments findDocument(@PathVariable Integer id) {
		return typeDocumentsService.findDocument(id);
	}

}
