package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.PiecesJointes;

public interface PiecesJointesService {
	
	public List<PiecesJointes> findAllPiecesJointes();
	public PiecesJointes findPiecesJointes(Integer id);
	public void savePiecesJointes(PiecesJointes PJ);
	public void UpdatePiecesJointes(PiecesJointes PJ);
	public void DeletePiecesJointes(Integer id);

}
