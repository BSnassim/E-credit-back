package com.pfe.ecredit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeHistorique;

@Repository
public interface DemandeHistoriqueRepository extends JpaRepository<DemandeHistorique, Integer> {
	

	List<DemandeHistorique> findAllByIdDemande(Integer id);

	@Query(value = " select d from DemandeHistorique d where d.idDemande=(SELECT a.idDemande\r\n"
			+ "			  from DemandeCredit a\r\n"
			+ "			 where a.datePhase = (select max(datePhase) from DemandeCredit b where b.idUser=?1 ) )")

	List<DemandeHistorique> findByIdUserAndMaxDatePhase(String id);
	List<DemandeHistorique> findAllByIdDemandeOrderByDatePhase(Integer id);

}
