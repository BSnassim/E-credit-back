package com.pfe.ecredit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.ecredit.domain.DemandeCredit;
@Repository
public interface DemandeCreditRepository  extends JpaRepository<DemandeCredit, Integer>{

	public Optional<DemandeCredit> findByNumPiece(String num);
	
	public List<DemandeCredit> findAllByIdUserOrderByDatePhase(String id);
	
	@Query(value = "SELECT d from DemandeCredit d, Utilisateur u, SiAgence a WHERE d.idUser = u.id and u.agence.idAgence = ?1 group by "
			+ "d.idDemande, d.nom, d.prenom, d.sitFamiliale, d.typePiece, d.numPiece, d.dateNaissance\r\n"
			+ ", d.numCompte, d.dateCompte, d.idTypeCredit, d.montant, d.unite, d.nbreEcheance, d.idPhase,\r\n"
			+ "d.datePhase, d.idUser, d.complement, d.gsm, d.idSimulation")
	List<DemandeCredit> findByAgenceOrderByDatePhase(Integer id);
	
	
}
