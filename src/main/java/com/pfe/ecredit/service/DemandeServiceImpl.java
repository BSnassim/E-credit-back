package com.pfe.ecredit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeCredit;
import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.domain.DemandeHistorique;
import com.pfe.ecredit.repositories.DemandeCreditRepository;
import com.pfe.ecredit.repositories.DemandeGarantieRepository;
import com.pfe.ecredit.repositories.DemandeHistoriqueRepository;
import com.pfe.ecredit.repositories.DemandePieceJointeRepository;

@Service
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	private DemandeCreditRepository demandeCreditRepository;

	@Autowired
	private DemandeGarantieRepository demandeGarantieRepository;
	@Autowired
	private DemandePieceJointeRepository demandePieceJointeRepository;

	@Autowired
	private DemandeHistoriqueRepository demandeHistoriqueRepository;

	@Override
	public List<DemandeCredit> findAllDemande() {
		return (demandeCreditRepository.findAll() != null) ? demandeCreditRepository.findAll() : null;
	}

	@Override
	public DemandeCredit findDemande(Integer id) {
		return (demandeCreditRepository.findById(id).isPresent()) ? demandeCreditRepository.findById(id).get() : null;
	}
	
	@Override
	public Boolean demandeExists(Integer num) {
		return (demandeCreditRepository.findByNumPiece(num).isPresent() && 
				(demandeCreditRepository.findByNumPiece(num).get().getIdPhase() != 2 && demandeCreditRepository.findByNumPiece(num).get().getIdPhase() != 3));
	}

	@Override
	public void UpdateDemande(DemandeCredit dem) {
		demandeCreditRepository.save(dem);

	}

	@Override
	public void DeleteDemande(Integer id) {
		demandeCreditRepository.deleteById(id);

	}

	@Override
	@Transactional
	public void saveDemande(DemandeCredit demande) {
		try {
			// save into demandeCredit
			demande.setIdPhase(1);
			demande.setDatePhase(LocalDate.now());
			demandeCreditRepository.save(demande);

			// save into demandeGarantie
			
			if(!(demande.getGarantie().isEmpty())) {
				for(DemandeGarantie i : demande.getGarantie()) {
					i.setIdDemande(demande.getIdDemande());
					i.setIdNatureGarantie(i.getNature().getIdNature());
					i.setIdTypeGrt(i.getType().getId());
					 
				}
				demandeGarantieRepository.saveAll(demande.getGarantie());
			}

			// save into demandePieceJinte

			// Historique
			DemandeHistorique historique = new DemandeHistorique();
			historique.setIdPhase(1);
			historique.setDatePhase(LocalDate.now());
			historique.setIdDemande(demande.getIdDemande());
			demandeHistoriqueRepository.save(historique);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
