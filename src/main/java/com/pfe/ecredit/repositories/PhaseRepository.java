package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.Phase;
@Repository
public interface PhaseRepository extends JpaRepository<Phase, Integer>{

}
