package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SiTypeCredit;


@Repository
public interface SiTypeCreditRepository extends JpaRepository<SiTypeCredit, Integer>{

}