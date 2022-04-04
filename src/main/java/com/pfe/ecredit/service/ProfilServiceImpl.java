package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.Profil;
import com.pfe.ecredit.repositories.ProfilRepository;

@Service
public class ProfilServiceImpl implements ProfilService {

	@Autowired
	private ProfilRepository repo;

	@Override
	public List<Profil> findAllProfil() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Profil findProfil(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveProfil(Profil profil) {
		repo.save(profil);
	}

	@Override
	public void UpdateProfil(Profil profil) {
		repo.save(profil);
		
	}

	@Override
	public void DeleteProfil(Integer id) {
		repo.deleteById(id);
	}
	
	@Override
	public void DeleteProfils(List<Integer> ids) {
		repo.deleteAllById(ids);
	}

}
