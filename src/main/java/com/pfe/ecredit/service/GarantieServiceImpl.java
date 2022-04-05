package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.repositories.DemandeGarantieRepository;

public class GarantieServiceImpl implements GarantieService {

	@Autowired
	private DemandeGarantieRepository repo;

	@Override
	public List<DemandeGarantie> findAllGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeGarantie findGarantie(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveGarantie(DemandeGarantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void UpdateGarantie(DemandeGarantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void DeleteGarantie(Integer id) {
		repo.deleteById(id);
		
	}
}
