package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeCredit;
import com.pfe.ecredit.repositories.DemandeCreditRepository;
@Service
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	private DemandeCreditRepository repo;

	@Override
	public List<DemandeCredit> findAllDemande() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public DemandeCredit findDemande(Integer id) {
		return (repo.findById(id).isPresent()) ? repo.findById(id).get() : null;
	}

	@Override
	public void saveDemande(DemandeCredit dem) {
		repo.save(dem);

	}

	@Override
	public void UpdateDemande(DemandeCredit dem) {
		repo.save(dem);

	}

	@Override
	public void DeleteDemande(Integer id) {
		repo.deleteById(id);

	}

}
