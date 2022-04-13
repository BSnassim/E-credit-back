package com.pfe.ecredit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeCredit;
@Repository
public interface DemandeCreditRepository  extends JpaRepository<DemandeCredit, Integer>{

	public Optional<DemandeCredit> findByNumPiece(String num);
	
	public List<DemandeCredit> findAllByIdUser(Integer id);
}
