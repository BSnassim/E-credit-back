package com.pfe.ecredit.service;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
//>>>>>>> origin/master
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
	public void UpdateDemande(DemandeCredit dem) {
		demandeCreditRepository.save(dem);

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

			// Historique
			DemandeHistorique historique = new DemandeHistorique();
			historique.setIdPhase(1);
			historique.setDatePhase(LocalDate.now());
			historique.setIdDemande(demande.getIdDemande());
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
					listPieceJointe.get(i).setChemin(pathPj + listPieceJointe.get(i).getFileName());
					listPieceJointe.get(i).setIdDemande(demande.getIdDemande());

					// save info doc in bade
					demandePieceJointeRepository.save(listPieceJointe.get(i));

					// save doc sue repertoire
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
	public List<DemandeCredit> findAllByUser(Integer id) {
		return (demandeCreditRepository.findAllByIdUser(id) != null) ? demandeCreditRepository.findAllByIdUser(id) : null;
	}

}
