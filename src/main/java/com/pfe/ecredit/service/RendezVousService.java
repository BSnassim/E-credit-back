package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeRendezVous;

public interface RendezVousService {

	public List<DemandeRendezVous> findAllRendezVous();
	
	public List<DemandeRendezVous>  findRendezVousByIdUser(String id);
	
	public void saveRendezVous(DemandeRendezVous rendezVous);
	
	public void DeleteRendezVous(Integer id);
}
