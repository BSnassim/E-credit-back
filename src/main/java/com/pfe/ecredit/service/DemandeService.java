package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeCredit;
import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.domain.DemandePieceJointe;

public interface DemandeService {

	public List<DemandeCredit> findAllDemande();

	public DemandeCredit findDemande(Integer id);

	public void saveDemande(DemandeCredit demande);

	public void UpdateDemande(DemandeCredit dem);

	public void DeleteDemande(Integer id);

}
