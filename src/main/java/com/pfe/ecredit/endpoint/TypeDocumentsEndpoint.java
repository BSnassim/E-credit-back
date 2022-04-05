package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.TypeDocuments;
import com.pfe.ecredit.service.TypeDocumentsService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class TypeDocumentsEndpoint {
	
	@Autowired(required=false)
	private TypeDocumentsService typeDocumentsService;
	
	@GetMapping("/piecesJointes")
	public List<TypeDocuments> findAllDocuments(){
		return typeDocumentsService.findAllDocuments();
	}
	
	@GetMapping("/piecesJointes/{id}")
	public TypeDocuments findDocument(@PathVariable Integer id) {
		return typeDocumentsService.findDocument(id);
	}

}
