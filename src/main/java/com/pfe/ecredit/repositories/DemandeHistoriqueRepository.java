package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeHistorique;

@Repository
public interface DemandeHistoriqueRepository extends JpaRepository<DemandeHistorique, Integer>{
	
	List<DemandeHistorique> findAllByIdDemande(Integer id);
}
