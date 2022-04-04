package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Phase;

public interface PhaseService {
	
	public List<Phase> findAllPhase();
	public Phase findPhase(Integer id);
	public void savePhase(Phase ph);
	public void UpdatePhase(Phase ph);
	public void DeletePhase(Integer id);

}
