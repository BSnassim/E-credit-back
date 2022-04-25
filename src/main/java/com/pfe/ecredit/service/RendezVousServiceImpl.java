package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeRendezVous;
import com.pfe.ecredit.repositories.DemandeRendezVousRepository;

@Service
public class RendezVousServiceImpl implements RendezVousService {

	@Autowired
	private DemandeRendezVousRepository RDVrepo;

	@Override
	public List<DemandeRendezVous> findAllRendezVous() {
		return (RDVrepo.findAll() != null) ? RDVrepo.findAll() : null;
	}

	@Override
	public List<DemandeRendezVous> findRendezVousByIdUser(Integer user) {
		return (RDVrepo.findByIdUser(user) != null) ? RDVrepo.findByIdUser(user) : null;
	}

	@Override
	public void saveRendezVous(DemandeRendezVous rendezVous) {
		RDVrepo.save(rendezVous);

	}

	@Override
	public void DeleteRendezVous(Integer id) {
		RDVrepo.deleteById(id);
	}

}
