package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.DemandeRendezVous;
import com.pfe.ecredit.service.RendezVousService;

@RequestMapping("/gestionRdv")
@CrossOrigin
@RestController
public class DemandeRendezVousEndpoint {
	
	@Autowired
	private RendezVousService rendezVousService;
	
	@GetMapping("/rdv")
	public List<DemandeRendezVous> findAllRendezVous(){
		return rendezVousService.findAllRendezVous();
	}
	
	@GetMapping("/rdv/{user}")
	public List<DemandeRendezVous >findRendezVousByIdUser(@PathVariable Integer user) {
		return rendezVousService.findRendezVousByIdUser(user);
	}
	

	@PostMapping("/rdv")
	public void saveRendezVous(@RequestBody DemandeRendezVous RendezVous) {
		rendezVousService.saveRendezVous(RendezVous);
	}
	
	@DeleteMapping("/rdv/{id}")
	public void deleteRendezVous(@PathVariable Integer id) {
		rendezVousService.DeleteRendezVous(id);
	}


}
