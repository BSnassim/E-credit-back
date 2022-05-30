package com.pfe.ecredit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	public Boolean demandeExists(String num) {
		return (demandeCreditRepository.findByNumPiece(num).isPresent()
				&& (demandeCreditRepository.findByNumPiece(num).get().getIdPhase() != 2
						&& demandeCreditRepository.findByNumPiece(num).get().getIdPhase() != 3));
	}


	@Override
	public void DeleteDemande(Integer id) {
		demandeCreditRepository.deleteById(id);

	}

	@Override
	@Transactional
	public void saveDemande(DemandeCredit demande) throws Exception {
		try {
			// save into demandeCredit
			demande.setIdPhase(1);
			demande.setDatePhase(LocalDate.now());
			demandeCreditRepository.save(demande);

			// save into demandeGarantie

			if (!(demande.getGarantie().isEmpty())) {
				for (DemandeGarantie i : demande.getGarantie()) {
					i.setIdDemande(demande.getIdDemande());
					i.setIdNatureGarantie(i.getNature().getIdNature());
					i.setIdTypeGrt(i.getType().getId());

				}
				demandeGarantieRepository.saveAll(demande.getGarantie());
			}

			// save into demandePieceJointe

			uploadDocumentDemande(demande.getPieces(), demande);

			// save into Historique
			DemandeHistorique historique = new DemandeHistorique();
			historique.setIdPhase(1);
			historique.setDatePhase(LocalDateTime.now());
			historique.setIdDemande(demande.getIdDemande());
			historique.setUserId(demande.getChangerId());
			demandeHistoriqueRepository.save(historique);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	@Transactional
	public void UpdateDemande(DemandeCredit demande) throws Exception {
		try {
			// save into demandeCredit
			demandeCreditRepository.save(demande);

			// save into demandeGarantie

			if (!(demande.getGarantie().isEmpty() )) {
				for (DemandeGarantie i : demande.getGarantie()) {
					i.setIdDemande(demande.getIdDemande());
					i.setIdNatureGarantie(i.getNature().getIdNature());
					i.setIdTypeGrt(i.getType().getId());

				}
				demandeGarantieRepository.saveAll(demande.getGarantie());
			}

			// save into demandePieceJointe
			if(!(demande.getPieces()==null)) {
			uploadDocumentDemande(demande.getPieces(), demande);
			}
			// Historique
			DemandeHistorique historique = new DemandeHistorique();
			historique.setIdPhase(demande.getIdPhase());
			historique.setDatePhase(LocalDateTime.now());
			historique.setIdDemande(demande.getIdDemande());
			historique.setUserId(demande.getChangerId());
			demandeHistoriqueRepository.save(historique);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Transactional
	private void uploadDocumentDemande(List<DemandePieceJointe> listPieceJointe, DemandeCredit demande)
			throws Exception {

		try {
			String pathPj = "C:\\uploadedFiles\\";
			File dir1 = new File(pathPj + "\\" + demande.getIdDemande());
			dir1.mkdirs();

			for (int i = 0; i < listPieceJointe.size(); i++) {
				if (listPieceJointe.get(i).getFileContent() != null) {
					listPieceJointe.get(i).setChemin(pathPj + "\\" + demande.getIdDemande() + "\\" + listPieceJointe.get(i).getFileName());
					listPieceJointe.get(i).setIdDemande(demande.getIdDemande());

					// save info doc in db
					demandePieceJointeRepository.save(listPieceJointe.get(i));

					// save doc in directory
					FileOutputStream outputStream1 = new FileOutputStream(
							dir1 + "\\" + listPieceJointe.get(i).getFileName());
					outputStream1.write(listPieceJointe.get(i).getFileContent());
					outputStream1.flush();
					outputStream1.close();
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<DemandeCredit> findAllByUser(String id) {

		return (demandeCreditRepository.findAllByIdUserOrderByDatePhase(id) != null) ? demandeCreditRepository.findAllByIdUserOrderByDatePhase(id) : null;
	}

	@Override
	public List<DemandeCredit> findByAgence(Integer id) {
		return (demandeCreditRepository.findByAgenceOrderByDatePhase(id) != null) ? demandeCreditRepository.findByAgenceOrderByDatePhase(id) : null;
	}

	@Override
	public List<DemandeCredit> findAllByYear(Integer idAgence) {
		return (demandeCreditRepository.findAllByAgenceAndCurrentYear(idAgence) != null) ? demandeCreditRepository.findAllByAgenceAndCurrentYear(idAgence):null;
	}

}
