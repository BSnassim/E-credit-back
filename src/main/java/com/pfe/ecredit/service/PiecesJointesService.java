package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pfe.ecredit.domain.DemandePieceJointe;

public interface PiecesJointesService {
	
	public List<DemandePieceJointe> findAllPiecesJointes();
	public DemandePieceJointe findPiecesJointes(Integer id);
	public void savePiecesJointes(MultipartFile[] PJ);
	public void UpdatePiecesJointes(DemandePieceJointe PJ);
	public void DeletePiecesJointes(Integer id);

}
