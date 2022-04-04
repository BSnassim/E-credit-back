package com.pfe.ecredit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Integer>{

}
