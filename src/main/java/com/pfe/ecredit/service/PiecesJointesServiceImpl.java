/**
 * 
 */
package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfe.ecredit.domain.PiecesJointes;
import com.pfe.ecredit.repositories.PiecesJointesRepository;

/**
 * @author Nassim.BenSalah
 *
 */
public class PiecesJointesServiceImpl implements PiecesJointesService {

	@Autowired
	private PiecesJointesRepository repo;

	@Override
	public List<PiecesJointes> findAllPiecesJointes() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public PiecesJointes findPiecesJointes(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void savePiecesJointes(PiecesJointes PJ) {
		repo.save(PJ);
		
	}

	@Override
	public void UpdatePiecesJointes(PiecesJointes PJ) {
		repo.save(PJ);
		
	}

	@Override
	public void DeletePiecesJointes(Integer id) {
		repo.deleteById(id);
		
	}
}
