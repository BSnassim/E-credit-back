package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SimulationCredit;

public interface SimulationCreditService {
	
	public List<SimulationCredit> findAll();
	public List<SimulationCredit> findByUser(Integer id);
	public void saveSimulation(SimulationCredit sim);

}
