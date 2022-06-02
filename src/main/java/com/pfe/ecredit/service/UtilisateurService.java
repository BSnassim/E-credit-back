package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Utilisateur;

public interface UtilisateurService {
	
	public List<Utilisateur> findAllUser();
	public List<Utilisateur> findUsersByIdAgence(Integer id);
	public Utilisateur findUser(String id);
	public Utilisateur userExists(String email);
	public void saveUser(Utilisateur user);
	public void UpdateUser(Utilisateur user);
	public void DeleteUser(String id);
	public void DeleteUsers(List<String> ids);

}
