package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SiTypeGarantie;
import com.pfe.ecredit.service.TypeGarantieService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class TypeGarantieEndpoint {

	@Autowired
	TypeGarantieService typeGarantieService;

	@GetMapping("/typeGarantie")
	public List<SiTypeGarantie> fetchDetails() {
		return typeGarantieService.findAllTypeGarantie();
	}
	
	@GetMapping("/typeGarantie/{id}")
	public SiTypeGarantie findTypeGarantie(@PathVariable Integer id) {
		return typeGarantieService.findTypeGarantie(id);
	}

}
