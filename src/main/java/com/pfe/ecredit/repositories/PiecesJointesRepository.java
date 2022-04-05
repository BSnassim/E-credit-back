package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.PiecesJointes;

@Repository
public interface PiecesJointesRepository extends JpaRepository<PiecesJointes, Integer>{
}
