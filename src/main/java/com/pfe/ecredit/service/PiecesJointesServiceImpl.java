/**
 * 
 */
package com.pfe.ecredit.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	public void savePiecesJointes(MultipartFile[] PJ) {
		File directory = new File("C:\\uploadedFiles");
        if (! directory.exists()){
            directory.mkdir();
        }
        Arrays.asList(PJ).stream().forEach(file -> {
            byte[] bytes = new byte[0];
            try {
                bytes = file.getBytes();
                Files.write(Paths.get("C:\\uploadedFiles" + file.getOriginalFilename()), bytes);
            } catch (IOException e) {

            }
        });
		
	}

	@Override
	public void UpdatePiecesJointes(DemandePieceJointe PJ) {
		repo.save(PJ);
		
	}

	@Override
	public void DeletePiecesJointes(Integer id) {
		repo.deleteById(id);
		
	}
}
