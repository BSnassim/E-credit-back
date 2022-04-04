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

import com.pfe.ecredit.domain.Phase;
import com.pfe.ecredit.service.PhaseService;

@RequestMapping("/credit")
@CrossOrigin
@RestController
public class PhaseEndpoint {
	
	@Autowired(required=false)
	private PhaseService PhaseService;
	
	@GetMapping("/phase")
	public List<Phase> findAllPhase(){
		return PhaseService.findAllPhase();
	}
	
	@GetMapping("/phase/{id}")
	public Phase findPhase(@PathVariable Integer id) {
		return PhaseService.findPhase(id);
	}
	
	@PostMapping("/phase")
	public void savePhase(@RequestBody Phase Phase) {
		PhaseService.savePhase(Phase);
	}
	
	@PutMapping("/phase")
	public void updatePhase(@RequestBody Phase Phase) {
		PhaseService.UpdatePhase(Phase);
	}
	
	@DeleteMapping("/phase/{id}")
	public void deletePhase(@PathVariable Integer id) {
		PhaseService.DeletePhase(id);
	}


}
