package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.Habilitation;
import com.pfe.ecredit.repositories.HabilitationRepository;

@Service
public class HabilitationServiceImpl implements HabilitationService {
	
	@Autowired
	private HabilitationRepository repo;

	@Override
	public List<Habilitation> findAllHabilitation() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Habilitation findHabilitation(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveHabilitation(Habilitation hab) {
		repo.save(hab);
		
	}

	@Override
	public void UpdateHabilitation(Habilitation hab) {
		repo.save(hab);
	}

	@Override
	public void DeleteHabilitation(Integer id) {
		repo.deleteById(id);
		
	}

}
