package com.pfe.ecredit.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.pfe.ecredit.domain.DemandePieceJointe;

public interface PiecesJointesService {
	
	public List<DemandePieceJointe> findAllPiecesJointes();
	public DemandePieceJointe findPiecesJointes(Integer id);
	public List<DemandePieceJointe> findByDemande(Integer id) throws FileNotFoundException, IOException;
	public void savePiecesJointes(DemandePieceJointe PJ);
	public void UpdatePiecesJointes(DemandePieceJointe PJ);
	public void DeletePiecesJointes(Integer id);

}
