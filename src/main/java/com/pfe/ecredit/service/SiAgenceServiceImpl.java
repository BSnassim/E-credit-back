package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SiAgence;
import com.pfe.ecredit.repositories.SiAgenceRepository;

@Service
public class SiAgenceServiceImpl implements SiAgenceService {
	
	@Autowired
	SiAgenceRepository repo;

	@Override
	public List<SiAgence> findAllAgence() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public SiAgence findAgence(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

}
