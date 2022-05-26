package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeCredit;

public interface DemandeService {

	public List<DemandeCredit> findAllDemande();

	public DemandeCredit findDemande(Integer id);
	
	public List<DemandeCredit> findAllByUser(String id);
	
	public List<DemandeCredit> findByAgence(Integer id);

	public Boolean demandeExists(String num);

	public void saveDemande(DemandeCredit demande) throws Exception;

	public void UpdateDemande(DemandeCredit dem) throws Exception;

	public void DeleteDemande(Integer id);

}
