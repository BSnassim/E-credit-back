package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> findAllUser();
	public Utilisateur findUser(Integer id);
	public Utilisateur userExists(String email);
	public void saveUser(Utilisateur user);
	public void UpdateUser(Utilisateur user);
	public void DeleteUser(Integer id);
	public void DeleteUsers(List<Integer> ids);

}
