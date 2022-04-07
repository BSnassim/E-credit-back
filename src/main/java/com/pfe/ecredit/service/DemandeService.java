package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeCredit;

public interface DemandeService {

	public List<DemandeCredit> findAllDemande();

	public DemandeCredit findDemande(Integer id);
	
	public Boolean demandeExists(Integer num);

	public void saveDemande(DemandeCredit demande);

	public void UpdateDemande(DemandeCredit dem);

	public void DeleteDemande(Integer id);

}
