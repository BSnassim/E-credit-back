package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.DemandeHistorique;
import com.pfe.ecredit.service.DemandeHistoriqueService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class DemandeHistoriqueEndpoint {

	@Autowired
	private DemandeHistoriqueService historiqueService;

	@GetMapping("/historique")
	public List<DemandeHistorique> findAllHistorique() {
		return historiqueService.findAll();
	}

	@GetMapping("/historique/ByDemande/{id}")
	public List<DemandeHistorique> findhistoriqueByDemande(@PathVariable Integer id) {
		return historiqueService.findByDemande(id);
	}

	@GetMapping("/historique/DemandeRecente/ByUser/{id}")
	public List<DemandeHistorique> findHistoriqueDemandeRecente(@PathVariable String id) {
		return historiqueService.findHistoriqueDemandeRecente(id);
	}
}
