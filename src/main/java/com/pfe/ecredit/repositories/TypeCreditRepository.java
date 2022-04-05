package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.TypeCredit;


@Repository
public interface TypeCreditRepository extends JpaRepository<TypeCredit, String>{

}