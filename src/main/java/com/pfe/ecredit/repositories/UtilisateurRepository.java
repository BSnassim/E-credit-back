package com.pfe.ecredit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String>{
	
	public Optional<Utilisateur> findByEmail(String email);
	
	
	@Query(value = "SELECT t from Utilisateur t where t.agence.idAgence = ?1")
	public List<Utilisateur> findByIdAgence(Integer id);
}
