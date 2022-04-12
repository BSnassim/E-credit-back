package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeGarantie;
@Repository
public interface DemandeGarantieRepository extends JpaRepository<DemandeGarantie, Integer>{

}
