package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Profil;

public interface ProfilService {
	
	public List<Profil> findAllProfil();
	public Profil findProfil(Integer id);
	public void saveProfil(Profil profil);
	public void UpdateProfil(Profil profil);
	public void DeleteProfil(Integer id);
	public void DeleteProfils(List<Integer> ids);

}
