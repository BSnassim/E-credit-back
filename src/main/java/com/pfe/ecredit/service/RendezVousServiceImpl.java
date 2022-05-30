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
	public List<DemandeRendezVous> findRendezVousByIdUser(String id) {
		return (RDVrepo.findAllByIdUser(id) != null) ? RDVrepo.findAllByIdUser(id) : null;
	}

	@Override
	public void saveRendezVous(DemandeRendezVous rendezVous) {
		RDVrepo.save(rendezVous);

	}

	@Override
	public void DeleteRendezVous(Integer id) {
		RDVrepo.deleteById(id);
	}

	@Override
	public DemandeRendezVous findRendezVousByDemande(Integer id) {
		return (RDVrepo.findByIdDemande(id).isPresent() ? RDVrepo.findByIdDemande(id).get() : null);
	}

}
