package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.DemandeGarantie;

public interface GarantieService {

	public List<DemandeGarantie> findAllGarantie();
	public DemandeGarantie findGarantie(Integer id);
	public void saveGarantie(DemandeGarantie garantie);
	public void UpdateGarantie(DemandeGarantie garantie);
	public void DeleteGarantie(Integer id);
}
