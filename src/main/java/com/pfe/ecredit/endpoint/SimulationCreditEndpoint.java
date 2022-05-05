package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SimulationCredit;
import com.pfe.ecredit.service.SimulationCreditService;

@RequestMapping("/simulation")
@CrossOrigin
@RestController
public class SimulationCreditEndpoint {
	
	@Autowired
	private SimulationCreditService service;
	
	@GetMapping("")
	public List<SimulationCredit> findAllSimulation(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public SimulationCredit findSimulationByID(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@PostMapping("")
	public Integer saveSimulation(@RequestBody SimulationCredit sim) throws Exception {
		return service.saveSimulation(sim);
	}

}
