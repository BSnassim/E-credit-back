package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiTypeCredit;



public interface TypeCreditService {

	List<SiTypeCredit> findAllTypeCredit();
	SiTypeCredit findTypeCredit(Integer id);

	
}
