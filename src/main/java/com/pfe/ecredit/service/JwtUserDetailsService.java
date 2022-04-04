package com.pfe.ecredit.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pfe.ecredit.domain.Habilitation;
import com.pfe.ecredit.domain.Utilisateur;
import com.pfe.ecredit.repositories.UtilisateurRepository;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UtilisateurRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Utilisateur> user = repo.findByEmail(email);
		List<Habilitation> roles = user.get().getProfil().getHabilitations();
		if (user.isPresent()) {
			return new User(user.get().getEmail(), 
					user.get().getPassword(), 
					true,
					true,
					true,
					true,
					getAuthorities(roles)
					);
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(Collection<Habilitation> roles) {
		 
		        return getGrantedAuthorities(getPrivileges(roles));
		    }

		    private List<String> getPrivileges(Collection<Habilitation> roles) {
		 
		        List<String> privileges = new ArrayList<>();
		        for (Habilitation role : roles) {
		            privileges.add(role.getLibelle());
		        }
		        return privileges;
		    }

		    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		        List<GrantedAuthority> authorities = new ArrayList<>();
		        for (String privilege : privileges) {
		            authorities.add(new SimpleGrantedAuthority(privilege));
		        }
		        return authorities;
		    }
		    
}