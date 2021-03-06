package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SiAgence;

@Repository
public interface SiAgenceRepository extends JpaRepository<SiAgence, Integer> {

}
