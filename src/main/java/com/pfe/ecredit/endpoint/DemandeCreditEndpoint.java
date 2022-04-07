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

import com.pfe.ecredit.domain.DemandeCredit;
import com.pfe.ecredit.service.DemandeService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class DemandeCreditEndpoint {
	
	@Autowired(required=false)
	private DemandeService DemandeService;
	
	@GetMapping("/demande")
	public List<DemandeCredit> findAllDemande(){
		return DemandeService.findAllDemande();
	}
	
	@GetMapping("/demande/{id}")
	public DemandeCredit findDemande(@PathVariable Integer id) {
		return DemandeService.findDemande(id);
	}
	
	@GetMapping("/demande/{numPiece}")
	public Boolean demandeExists(@PathVariable Integer numPiece) {
		return DemandeService.demandeExists(numPiece);
	}
	
	@PostMapping("/demande")
	public void saveDemande(@RequestBody DemandeCredit Demande) {
		System.out.println(Demande);
		DemandeService.saveDemande(Demande);
	}
	
	@PutMapping("/demande")
	public void updateDemande(@RequestBody DemandeCredit Demande) {
		DemandeService.UpdateDemande(Demande);
	}
	
	@DeleteMapping("/demande/{id}")
	public void deleteDemande(@PathVariable Integer id) {
		DemandeService.DeleteDemande(id);
	}



}
