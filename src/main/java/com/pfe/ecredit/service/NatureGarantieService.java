package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiNatureGarantie;



public interface NatureGarantieService {

	List<SiNatureGarantie> findAllNatureGarantie();
	SiNatureGarantie findNatureGarantie(Integer id);

	
}
