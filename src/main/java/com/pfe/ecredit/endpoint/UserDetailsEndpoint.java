package com.pfe.ecredit.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.Utilisateur;
import com.pfe.ecredit.service.UtilisateurService;

@RequestMapping("/Utilisateur")
@CrossOrigin
@RestController
public class UserDetailsEndpoint {
	
	@Autowired
	private UtilisateurService userService;
	
	@GetMapping("/{id}")
	public Utilisateur findUtilisateur(@PathVariable String id) {
		return userService.findUser(id);
	}

}
