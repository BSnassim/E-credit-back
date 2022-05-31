package com.pfe.ecredit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeRendezVous;

@Repository
public interface DemandeRendezVousRepository extends JpaRepository<DemandeRendezVous, Integer> {

	public List<DemandeRendezVous> findAllByIdUser(String id);
	
	public Optional<DemandeRendezVous> findByIdDemande(Integer id);

}
