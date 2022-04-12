package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SiNatureGarantie;
import com.pfe.ecredit.service.NatureGarantieService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class NatureGarantieEndpoint {

	@Autowired
	private NatureGarantieService natureGarantieService;

	@GetMapping("/natureGarantie")
	public List<SiNatureGarantie> fetchDetails() {
		return natureGarantieService.findAllNatureGarantie();
	}

}
