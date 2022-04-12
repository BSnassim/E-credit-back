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

import com.pfe.ecredit.domain.Habilitation;
import com.pfe.ecredit.service.HabilitationService;

@RequestMapping("/administration")
@CrossOrigin
@RestController
public class HabilitationEndpoint {
	
	@Autowired
	private HabilitationService habService;
	
	@GetMapping("/habilitations")
	public List<Habilitation> findAllHabilitation(){
		return habService.findAllHabilitation();
	}
	
	@GetMapping("/habilitations/{id}")
	public Habilitation findHabilitation(@PathVariable Integer id) {
		return habService.findHabilitation(id);
	}
	
	@PostMapping("/habilitations")
	public void saveHabilitation(@RequestBody Habilitation hab) {
		habService.saveHabilitation(hab);
	}
	
	@PutMapping("/habilitations")
	public void updateHabilitation(@RequestBody Habilitation hab) {
		habService.UpdateHabilitation(hab);
	}
	
	@DeleteMapping("/habilitations/{id}")
	public void deleteHabilitation(@PathVariable Integer id) {
		habService.DeleteHabilitation(id);
	}

}
