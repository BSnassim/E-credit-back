package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.ecredit.domain.Demande;

public interface DemandeRepository  extends JpaRepository<Demande, Integer>{

}
