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
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.PiecesJointes;
import com.pfe.ecredit.service.PiecesJointesService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class PiecesJointesEndpoint {
	
	@Autowired(required=false)
	private PiecesJointesService PiecesJointesService;
	
	@GetMapping("/piecesJointes")
	public List<PiecesJointes> findAllPiecesJointes(){
		return PiecesJointesService.findAllPiecesJointes();
	}
	
	@GetMapping("/piecesJointes/{id}")
	public PiecesJointes findPiecesJointes(@PathVariable Integer id) {
		return PiecesJointesService.findPiecesJointes(id);
	}
	
	@PostMapping("/piecesJointes")
	public void savePiecesJointes(@RequestBody PiecesJointes PiecesJointes) {
		PiecesJointesService.savePiecesJointes(PiecesJointes);
	}
	
	@PutMapping("/piecesJointes")
	public void updatePiecesJointes(@RequestBody PiecesJointes PiecesJointes) {
		PiecesJointesService.UpdatePiecesJointes(PiecesJointes);
	}
	
	@DeleteMapping("/piecesJointes/{id}")
	public void deletePiecesJointes(@PathVariable Integer id) {
		PiecesJointesService.DeletePiecesJointes(id);
	}


}
