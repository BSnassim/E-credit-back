package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Demande;

public interface DemandeService {
	
	public List<Demande> findAllDemande();
	public Demande findDemande(Integer id);
	public void saveDemande(Demande dem);
	public void UpdateDemande(Demande dem);
	public void DeleteDemande(Integer id);

}
