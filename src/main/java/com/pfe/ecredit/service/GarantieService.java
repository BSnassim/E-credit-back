package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Garantie;

public interface GarantieService {

	public List<Garantie> findAllGarantie();
	public Garantie findGarantie(Integer id);
	public void saveGarantie(Garantie garantie);
	public void UpdateGarantie(Garantie garantie);
	public void DeleteGarantie(Integer id);
}
