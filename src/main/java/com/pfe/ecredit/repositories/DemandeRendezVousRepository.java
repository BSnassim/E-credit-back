package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeRendezVous;

@Repository
public interface DemandeRendezVousRepository extends JpaRepository<DemandeRendezVous, Integer> {

	public List<DemandeRendezVous> findByIdUser(String id);

}
