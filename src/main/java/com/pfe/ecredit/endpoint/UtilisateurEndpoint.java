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

import com.pfe.ecredit.domain.Utilisateur;
import com.pfe.ecredit.service.UtilisateurService;

@RequestMapping("/administration")
@CrossOrigin
@RestController
public class UtilisateurEndpoint {
	
	@Autowired(required=false)
	private UtilisateurService userService;
	
	@GetMapping("/users")
	public List<Utilisateur> findAllUtilisateur(){
		return userService.findAllUser();
	}
	
//	@GetMapping("/users/{id}")
//	public Utilisateur findUtilisateur(@PathVariable Integer id) {
//		return userService.findUser(id);
//	}
	
	@GetMapping("/users/{email}")
	public Utilisateur userExists(@PathVariable String email) {
		return userService.userExists(email);
	}
	
	@PostMapping("/users")
	public void saveUtilisateur(@RequestBody Utilisateur Utilisateur) {
		userService.saveUser(Utilisateur);
	}
	
	@PutMapping("/users")
	public void updateUtilisateur(@RequestBody Utilisateur Utilisateur) {
		userService.UpdateUser(Utilisateur);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUtilisateur(@PathVariable Integer id) {
		userService.DeleteUser(id);
	}

	@DeleteMapping("/users/deleteAll/{ids}")
	public void deleteUtilisateurs(@PathVariable List<Integer> ids) {
		userService.DeleteUsers(ids);
	}

}
