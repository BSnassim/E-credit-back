package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.Phase;
import com.pfe.ecredit.repositories.PhaseRepository;

@Service
public class PhaseServiceImpl implements PhaseService {

	@Autowired
	private PhaseRepository repo;

	@Override
	public List<Phase> findAllPhase() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Phase findPhase(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void savePhase(Phase ph) {
		repo.save(ph);
		
	}

	@Override
	public void UpdatePhase(Phase ph) {
		repo.save(ph);
		
	}

	@Override
	public void DeletePhase(Integer id) {
		repo.deleteById(id);
		
	}
}
