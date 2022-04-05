package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeCredit;

public interface DemandeService {
	
	public List<DemandeCredit> findAllDemande();
	public DemandeCredit findDemande(Integer id);
	public void saveDemande(DemandeCredit dem);
	public void UpdateDemande(DemandeCredit dem);
	public void DeleteDemande(Integer id);

}
