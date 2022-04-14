package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SiNatureGarantie;
import com.pfe.ecredit.repositories.SiNatureGarantieRepository;

@Service
public class NatureGarantieServiceImpl implements NatureGarantieService {

	@Autowired
	private SiNatureGarantieRepository repo;

//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public List<NatureGarantie> findAllNatureGarantie() {
//
//		List<com.pfe.ecredit.domain.NatureGarantie> result = natureGarantieRepository.findAll();
//		return (result == null) ? null
//				: result.parallelStream().map(emp -> modelMapper.map(emp, NatureGarantie.class))
//						.collect(Collectors.toList());
//
//	}
	
	@Override
	public List<SiNatureGarantie> findAllNatureGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

	@Override
	public SiNatureGarantie findNatureGarantie(Integer id) {
		return (repo.findById(id).isPresent())? repo.findById(id).get() : null;
	}

}
