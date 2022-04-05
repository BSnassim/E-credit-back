package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.NatureGarantie;
import com.pfe.ecredit.repositories.NatureGarantieRepository;

@Service
public class NatureGarantieServiceImpl implements NatureGarantieService {

	@Autowired
	private NatureGarantieRepository repo;

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
	public List<NatureGarantie> findAllNatureGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

}
