package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SiTypeGarantie;



@Repository
public interface SiTypeGarantieRepository extends JpaRepository<SiTypeGarantie, Integer>{

}