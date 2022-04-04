package com.pfe.ecredit.service;

import java.util.List;

import com.pfe.ecredit.domain.Habilitation;

public interface HabilitationService {
	
	public List<Habilitation> findAllHabilitation();
	public Habilitation findHabilitation(Integer id);
	public void saveHabilitation(Habilitation hab);
	public void UpdateHabilitation(Habilitation hab);
	public void DeleteHabilitation(Integer id);

}
