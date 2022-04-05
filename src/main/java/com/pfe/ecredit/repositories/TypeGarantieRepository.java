package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.TypeGarantie;



@Repository
public interface TypeGarantieRepository extends JpaRepository<TypeGarantie, String>{

}