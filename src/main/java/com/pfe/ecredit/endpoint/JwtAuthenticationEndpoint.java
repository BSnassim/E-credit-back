package com.pfe.ecredit.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.config.JwtRequest;
import com.pfe.ecredit.config.JwtResponse;
import com.pfe.ecredit.config.JwtTokenUtil;
import com.pfe.ecredit.config.PasswordEncoderCreation;
import com.pfe.ecredit.domain.Utilisateur;
import com.pfe.ecredit.service.JwtUserDetailsService;
import com.pfe.ecredit.service.UtilisateurService;


@RestController
@CrossOrigin
public class JwtAuthenticationEndpoint {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private UtilisateurService userService;
	
	@Autowired
	private PasswordEncoderCreation pwEN;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getId(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getId());

		final String token = jwtTokenUtil.generateToken(userDetails);
		
		final Utilisateur user = userService.findUser(authenticationRequest.getId());

		return ResponseEntity.ok(new JwtResponse(token,
				user.getProfil().getHabilitations()
				));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/getUserByToken/{token}", method = RequestMethod.GET)
	public Utilisateur getUserByToken(@PathVariable String token) {
		String id = jwtTokenUtil.getUsernameFromToken(token);
		return userService.findUser(id);
	}
	
	@RequestMapping(value = "authenticate/checkPassword", method = RequestMethod.GET)
	public Boolean checkPassword(@RequestParam(name = "rawPassword") String rawPassword, @RequestParam(name = "encodedPassword") String encodedPassword) {
		return pwEN.myPasswordEncoder().matches(rawPassword, encodedPassword);
	}
}