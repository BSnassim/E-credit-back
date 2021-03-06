package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SimulationCredit;
import com.pfe.ecredit.repositories.SimulationCreditRepository;

@Service
public class SimulationCreditServiceImpl implements SimulationCreditService {

	@Autowired
	private SimulationCreditRepository rep;
	
	@Override
	public List<SimulationCredit> findAll() {
		return (rep.findAll() != null) ? rep.findAll() : null;
	}

	@Override
	public List<SimulationCredit> findByUser(String id) {
		return (rep.findAllByIdUser(id) != null) ? rep.findAllByIdUser(id) : null;
	}

	@Override
	public Integer saveSimulation(SimulationCredit sim) {
		rep.save(sim);
		return sim.getIdSim();
	}

	@Override
	public SimulationCredit findById(Integer id) {
		return (rep.findById(id).isPresent()) ? rep.findById(id).get() : null;
	}

}
