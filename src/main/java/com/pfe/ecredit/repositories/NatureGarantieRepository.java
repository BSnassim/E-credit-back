package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.NatureGarantie;



@Repository
public interface NatureGarantieRepository extends JpaRepository<NatureGarantie, String>{

}