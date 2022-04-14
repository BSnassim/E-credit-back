package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiTypeGarantie;



public interface TypeGarantieService {

	List<SiTypeGarantie> findAllTypeGarantie();
	SiTypeGarantie findTypeGarantie(Integer id);

	
}
