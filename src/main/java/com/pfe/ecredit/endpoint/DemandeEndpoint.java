package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.Demande;
import com.pfe.ecredit.service.DemandeService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class DemandeEndpoint {
	
	@Autowired(required=false)
	private DemandeService DemandeService;
	
	@GetMapping("/demande")
	public List<Demande> findAllDemande(){
		return DemandeService.findAllDemande();
	}
	
	@GetMapping("/demande/{id}")
	public Demande findDemande(@PathVariable Integer id) {
		return DemandeService.findDemande(id);
	}
	
	@PostMapping("/demande")
	public void saveDemande(@RequestBody Demande Demande) {
		DemandeService.saveDemande(Demande);
	}
	
	@PutMapping("/demande")
	public void updateDemande(@RequestBody Demande Demande) {
		DemandeService.UpdateDemande(Demande);
	}
	
	@DeleteMapping("/demande/{id}")
	public void deleteDemande(@PathVariable Integer id) {
		DemandeService.DeleteDemande(id);
	}



}
