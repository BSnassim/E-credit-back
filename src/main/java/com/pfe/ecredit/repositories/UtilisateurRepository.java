package com.pfe.ecredit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>{
	
	public Optional<Utilisateur> findByEmail(String email);

}
