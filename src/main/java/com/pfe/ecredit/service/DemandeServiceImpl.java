package com.pfe.ecredit.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeCredit;
import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.domain.DemandeHistorique;
import com.pfe.ecredit.domain.DemandePieceJointe;
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

			// save into demandePieceJointe
			File directory = new File("C:\\uploadedFiles");
	        if (! directory.exists()){
	            directory.mkdir();
	        }
	        Arrays.asList(demande.getPieces()).stream().forEach(file -> {
                byte[] bytes = new byte[0];
                try {
                    bytes = file.getBytes();
                    Files.write(Paths.get("C:\\uploadedFiles" + file.getOriginalFilename()), bytes);
                    DemandePieceJointe PJ = new DemandePieceJointe();
                    PJ.setChemin("C:\\uploadedFiles"+ file.getOriginalFilename());
                    PJ.setIdDemande(demande.getIdDemande());
                    PJ.setLibDoc(file.getOriginalFilename());
                    demandePieceJointeRepository.save(PJ);
                    
                } catch (IOException e) {

                }
	        });

			// Historique
			DemandeHistorique historique = new DemandeHistorique();
			historique.setIdPhase(1);
			historique.setDatePhase(LocalDate.now());
			historique.setIdDemande(demande.getIdDemande());
			historique.setUserPhase(demande.getUserId());
			demandeHistoriqueRepository.save(historique);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
