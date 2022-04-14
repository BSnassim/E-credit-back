package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeGarantie;
@Repository
public interface DemandeGarantieRepository extends JpaRepository<DemandeGarantie, Integer>{
	
	public List<DemandeGarantie> findAllByIdDemande(Integer id);

}
