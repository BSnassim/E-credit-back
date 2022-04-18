package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeRendezVous;
@Repository
public interface DemandeRendezVousRepository extends JpaRepository<DemandeRendezVous, Integer>{
	
	
}
