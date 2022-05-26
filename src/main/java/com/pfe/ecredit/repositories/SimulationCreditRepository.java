package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.SimulationCredit;

@Repository
public interface SimulationCreditRepository extends JpaRepository<SimulationCredit, Integer> {
	
	public List<SimulationCredit> findAllByIdUser(String id);

}
