package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.DemandeGarantie;
import com.pfe.ecredit.repositories.DemandeGarantieRepository;
import com.pfe.ecredit.repositories.SiNatureGarantieRepository;
import com.pfe.ecredit.repositories.SiTypeGarantieRepository;

@Service
public class GarantieServiceImpl implements GarantieService {

	@Autowired
	private DemandeGarantieRepository repo;
	@Autowired
	private TypeGarantieService servT;
	@Autowired
	private NatureGarantieService servN;

	@Override
	public List<DemandeGarantie> findAllGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public DemandeGarantie findGarantie(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

	@Override
	public void saveGarantie(DemandeGarantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void UpdateGarantie(DemandeGarantie garantie) {
		repo.save(garantie);
		
	}

	@Override
	public void DeleteGarantie(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<DemandeGarantie> findByDemande(Integer id) {
		List<DemandeGarantie> res =(repo.findAllByIdDemande(id) != null)? repo.findAllByIdDemande(id) : null;
		for (DemandeGarantie i : res) {
			i.setNature(servN.findNatureGarantie(i.getIdNatureGarantie()));
			i.setType(servT.findTypeGarantie(i.getIdTypeGrt()));
		}
		return res;
	}
}
