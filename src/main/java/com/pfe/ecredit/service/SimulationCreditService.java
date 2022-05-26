package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SimulationCredit;

public interface SimulationCreditService {
	
	public List<SimulationCredit> findAll();
	public List<SimulationCredit> findByUser(String id);
	public SimulationCredit findById(Integer id);
	public Integer saveSimulation(SimulationCredit sim);

}
