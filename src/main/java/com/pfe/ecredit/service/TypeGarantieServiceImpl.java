package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SiTypeGarantie;
import com.pfe.ecredit.repositories.SiTypeGarantieRepository;

@Service
public class TypeGarantieServiceImpl implements TypeGarantieService {

	@Autowired
	private SiTypeGarantieRepository repo;

//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public List<TypeGarantie> findAllTypeGarantie() {
//
//		List<com.pfe.ecredit.domain.TypeGarantie> result = typeGarantieRepository.findAll();
//		return (result == null) ? null
//				: result.parallelStream().map(emp -> modelMapper.map(emp, TypeGarantie.class))
//						.collect(Collectors.toList());
//
//	}
	
	@Override
	public List<SiTypeGarantie> findAllTypeGarantie() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

}
