package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SiAgence;
import com.pfe.ecredit.service.SiAgenceService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class SiAgenceEndpoint {
	
	@Autowired
	private SiAgenceService agenceService;

	@GetMapping("/agence")
	public List<SiAgence> fetchDetails() {
		return agenceService.findAllAgence();
	}
	
	@GetMapping("/agence/{id}")
	public SiAgence findTypeCredit(@PathVariable Integer id) {
		return agenceService.findAgence(id);
	}

}
