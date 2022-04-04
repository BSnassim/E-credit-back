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

import com.pfe.ecredit.domain.Garantie;
import com.pfe.ecredit.service.GarantieService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class GarantieEndpoint {
	
	@Autowired(required=false)
	private GarantieService GarantieService;
	
	@GetMapping("/garantie")
	public List<Garantie> findAllGarantie(){
		return GarantieService.findAllGarantie();
	}
	
	@GetMapping("/garantie/{id}")
	public Garantie findGarantie(@PathVariable Integer id) {
		return GarantieService.findGarantie(id);
	}
	
	@PostMapping("/garantie")
	public void saveGarantie(@RequestBody Garantie Garantie) {
		GarantieService.saveGarantie(Garantie);
	}
	
	@PutMapping("/garantie")
	public void updateGarantie(@RequestBody Garantie Garantie) {
		GarantieService.UpdateGarantie(Garantie);
	}
	
	@DeleteMapping("/garantie/{id}")
	public void deleteGarantie(@PathVariable Integer id) {
		GarantieService.DeleteGarantie(id);
	}


}
