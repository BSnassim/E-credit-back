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

import com.pfe.ecredit.domain.Profil;
import com.pfe.ecredit.service.ProfilService;

@RequestMapping("/administration")
@CrossOrigin
@RestController
public class ProfilEndpoint {
	
	@Autowired
	private ProfilService profilService;
	
	@GetMapping("/profils")
	public List<Profil> findAllProfil(){
		return profilService.findAllProfil();
	}
	
	@GetMapping("/profils/{id}")
	public Profil findProfil(@PathVariable Integer id) {
		return profilService.findProfil(id);
	}
	
	@PostMapping("/profils")
	public void saveProfil(@RequestBody Profil profil) {
		profilService.saveProfil(profil);
	}
	
	@PutMapping("/profils")
	public void updateProfil(@RequestBody Profil profil) {
		profilService.UpdateProfil(profil);
	}
	
	@DeleteMapping("/profils/{id}")
	public void deleteProfil(@PathVariable Integer id) {
		profilService.DeleteProfil(id);
	}

	@DeleteMapping("/profils/deleteAll/{ids}")
	public void deleteProfils(@PathVariable List<Integer> ids) {
		profilService.DeleteProfils(ids);
	}
}
