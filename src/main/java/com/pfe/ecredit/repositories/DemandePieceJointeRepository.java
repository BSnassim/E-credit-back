package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandePieceJointe;

@Repository
public interface DemandePieceJointeRepository extends JpaRepository<DemandePieceJointe, Integer>{
}