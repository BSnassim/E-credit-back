package com.pfe.ecredit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.ecredit.domain.SiTypeCredit;
import com.pfe.ecredit.repositories.SiTypeCreditRepository;

@Service
public class TypeCreditServiceImpl implements TypeCreditService {

	@Autowired
	private SiTypeCreditRepository repo;

//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Override
//	public List<TypeCredit> findAllTypeCredit() {
//
//		List<com.pfe.ecredit.domain.TypeCredit> result = typeCreditRepository.findAll();
//		return (result == null) ? null
//				: result.parallelStream().map(emp -> modelMapper.map(emp, TypeCredit.class))
//						.collect(Collectors.toList());
//
//	}
	
	@Override
	public List<SiTypeCredit> findAllTypeCredit() {
		return (repo.findAll() != null)? repo.findAll() : null;
	}

}
