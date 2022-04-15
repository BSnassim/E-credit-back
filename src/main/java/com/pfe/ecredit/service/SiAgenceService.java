package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.SiAgence;

public interface SiAgenceService {
	
	public List<SiAgence> findAllAgence();
	public SiAgence findAgence(Integer id);

}
