package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.ecredit.domain.DemandeCredit;

public interface DemandeCreditRepository  extends JpaRepository<DemandeCredit, Integer>{

}
