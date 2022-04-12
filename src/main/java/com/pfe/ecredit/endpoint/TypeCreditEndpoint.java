package com.pfe.ecredit.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ecredit.domain.SiTypeCredit;
import com.pfe.ecredit.service.TypeCreditService;

@RequestMapping("/credit")
@RestController
@CrossOrigin
public class TypeCreditEndpoint {

	@Autowired
	private TypeCreditService typeCreditService;

	@GetMapping("/typeCredit")
	public List<SiTypeCredit> fetchDetails() {
		return typeCreditService.findAllTypeCredit();
	}

}
