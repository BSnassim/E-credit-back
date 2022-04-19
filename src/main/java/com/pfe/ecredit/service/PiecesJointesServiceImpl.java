/**
 * 
 */
package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandePieceJointe;
import com.pfe.ecredit.repositories.DemandePieceJointeRepository;

@Service
public class PiecesJointesServiceImpl implements PiecesJointesService {

	@Autowired
	private DemandePieceJointeRepository repo;

	@Override
	public List<DemandePieceJointe> findAllPiecesJointes() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandePieceJointe findPiecesJointes(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
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
	public List<DemandePieceJointe> findByDemande(Integer id) {
		return (repo.findAllByIdDemande(id) != null)? repo.findAllByIdDemande(id) : null;
	}
}
