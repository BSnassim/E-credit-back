package com.pfe.ecredit.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.ecredit.domain.DemandePieceJointe;
import com.pfe.ecredit.repositories.DemandePieceJointeRepository;

@Service
public class PiecesJointesServiceImpl implements PiecesJointesService {

	@Autowired
	private DemandePieceJointeRepository repo;

	@Override
	public List<DemandePieceJointe> findAllPiecesJointes() {
		return (repo.findAll() != null) ? repo.findAll() : null;
	}

	@Override
	public DemandePieceJointe findPiecesJointes(Integer id) {
		return (repo.findById(id).isPresent()) ? repo.findById(id).get() : null;
	}

	@Override
	public void savePiecesJointes(DemandePieceJointe PJ) {
		repo.save(PJ);
	}

	@Override
	public void UpdatePiecesJointes(DemandePieceJointe PJ) {
		repo.save(PJ);

	}

	@Override
	public void DeletePiecesJointes(Integer id) {
		repo.deleteById(id);

	}

	@Override
	@Transactional
	public List<DemandePieceJointe> findByDemande(Integer id) throws FileNotFoundException, IOException {
		List<DemandePieceJointe> list = (repo.findAllByIdDemande(id) != null) ? repo.findAllByIdDemande(id) : null;
		try {
			for (DemandePieceJointe i : list) {
				FileInputStream fis = new FileInputStream("C:\\uploadedFiles\\" + id + "\\" + i.getFileName());
				i.setFileContent(fis.readAllBytes());
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
