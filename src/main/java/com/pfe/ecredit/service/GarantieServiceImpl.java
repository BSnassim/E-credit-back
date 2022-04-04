package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ecredit.domain.Garantie;
import com.pfe.ecredit.repositories.GarantieRepository;

public class GarantieServiceImpl implements GarantieService {

	@Autowired
	private GarantieRepository repo;

	@Override
	public List<Garantie> findAllGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Garantie findGarantie(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveGarantie(Garantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void UpdateGarantie(Garantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void DeleteGarantie(Integer id) {
		repo.deleteById(id);
		
	}
}
