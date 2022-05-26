package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeHistorique;

public interface DemandeHistoriqueService {
	
	public List<DemandeHistorique> findAll();
	public List<DemandeHistorique> findByDemande(Integer id);
	public List<DemandeHistorique> findHistoriqueDemandeRecente(String id);

}
