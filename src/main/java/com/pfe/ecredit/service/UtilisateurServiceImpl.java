package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.config.PasswordEncoderCreation;
import com.pfe.ecredit.domain.Utilisateur;
import com.pfe.ecredit.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurRepository repo;
	
	@Autowired
	private PasswordEncoderCreation pwEN;

	@Override
	public List<Utilisateur> findAllUser() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public Utilisateur findUser(String id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}
	
	@Override
	public Utilisateur userExists(String email) {
		return (repo.findByEmail(email).isPresent())? repo.findByEmail(email).get() : null;
	}

	@Override
	public void saveUser(Utilisateur user) {
		try {
		user.setPassword(pwEN.myPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
		} catch (javax.persistence.PersistenceException ex) 
		{
			System.out.println(ex);
		}
	}

	@Override
	public void UpdateUser(Utilisateur user) {
		user.setPassword(pwEN.myPasswordEncoder().encode(user.getPassword()));
		repo.save(user);
	}

	@Override
	public void DeleteUser(String id) {
		repo.deleteById(id);
	}

	@Override
	public void DeleteUsers(List<String> ids) {
		repo.deleteAllById(ids);		
	}

}
