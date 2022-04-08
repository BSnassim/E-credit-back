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

import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.service.GarantieService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class DemandeGarantieEndpoint {
	
	@Autowired(required=false)
	private GarantieService GarantieService;
	
	@GetMapping("/garantie")
	public List<DemandeGarantie> findAllGarantie(){
		return GarantieService.findAllGarantie();
	}
	
	@GetMapping("/garantie/{id}")
	public DemandeGarantie findGarantie(@PathVariable Integer id) {
		return GarantieService.findGarantie(id);
	}
	
	@PostMapping("/garantie")
	public void saveGarantie(@RequestBody DemandeGarantie Garantie) {
		GarantieService.saveGarantie(Garantie);
	}
	
//	@PutMapping("/garantie")
//	public void updateGarantie(@RequestBody DemandeGarantie Garantie) {
//		GarantieService.UpdateGarantie(Garantie);
//	}
	
	@DeleteMapping("/garantie/{id}")
	public void deleteGarantie(@PathVariable Integer id) {
		GarantieService.DeleteGarantie(id);
	}


}
