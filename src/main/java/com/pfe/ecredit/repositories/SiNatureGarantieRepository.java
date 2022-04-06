package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SiNatureGarantie;



@Repository
public interface SiNatureGarantieRepository extends JpaRepository<SiNatureGarantie, String>{

}