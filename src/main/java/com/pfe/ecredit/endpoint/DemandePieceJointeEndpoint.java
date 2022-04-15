package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.DemandePieceJointe;
import com.pfe.ecredit.service.PiecesJointesService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class DemandePieceJointeEndpoint {
	
	@Autowired
	private PiecesJointesService PiecesJointesService;
	
	@GetMapping("/piecesJointes")
	public List<DemandePieceJointe> findAllPiecesJointes(){
		return PiecesJointesService.findAllPiecesJointes();
	}
	
	@GetMapping("/piecesJointes/{id}")
	public DemandePieceJointe findPiecesJointes(@PathVariable Integer id) {
		return PiecesJointesService.findPiecesJointes(id);
	}
	
	@PostMapping("/piecesJointes")
	public void savePiecesJointes(@RequestParam DemandePieceJointe PiecesJointes) {
		PiecesJointesService.savePiecesJointes(PiecesJointes);
	}
	
	@PutMapping("/piecesJointes")
	public void updatePiecesJointes(@RequestBody DemandePieceJointe PiecesJointes) {
		PiecesJointesService.UpdatePiecesJointes(PiecesJointes);
	}
	
	@DeleteMapping("/piecesJointes/{id}")
	public void deletePiecesJointes(@PathVariable Integer id) {
		PiecesJointesService.DeletePiecesJointes(id);
	}


}
