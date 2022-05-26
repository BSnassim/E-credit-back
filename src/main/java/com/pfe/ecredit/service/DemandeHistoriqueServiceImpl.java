package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeHistorique;
import com.pfe.ecredit.repositories.DemandeHistoriqueRepository;

@Service
public class DemandeHistoriqueServiceImpl implements DemandeHistoriqueService {

	@Autowired
	private DemandeHistoriqueRepository repo;

	@Override
	public List<DemandeHistorique> findAll() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public List<DemandeHistorique> findByDemande(Integer id) {
		return (repo.findAllByIdDemande(id) != null) ? repo.findAllByIdDemande(id) : null;
	}

	@Override
	public List<DemandeHistorique> findHistoriqueDemandeRecente(Integer id) {
		return repo.findByIdUserAndMaxDatePhase(id);
	}

}
