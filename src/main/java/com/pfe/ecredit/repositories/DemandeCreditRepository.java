package com.pfe.ecredit.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.ecredit.domain.DemandeCredit;

public interface DemandeCreditRepository  extends JpaRepository<DemandeCredit, Integer>{

	public Optional<DemandeCredit> findByNumPiece(Integer num);
}
