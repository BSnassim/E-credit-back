package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ecredit.domain.Demande;
import com.pfe.ecredit.repositories.DemandeRepository;

public class DemandeServiceImpl implements DemandeService {
	
	@Autowired
	private DemandeRepository repo;

	@Override
	public List<Demande> findAllDemande() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Demande findDemande(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveDemande(Demande dem) {
		repo.save(dem);
		
	}

	@Override
	public void UpdateDemande(Demande dem) {
		repo.save(dem);
		
	}

	@Override
	public void DeleteDemande(Integer id) {
		repo.deleteById(id);
		
	}

}
