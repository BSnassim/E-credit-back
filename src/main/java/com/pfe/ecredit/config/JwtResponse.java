package com.pfe.ecredit.config;

import java.io.Serializable;
import java.util.List;

import com.pfe.ecredit.domain.Habilitation;

import lombok.Data;

@Data
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String token;
	private final List<Habilitation> roles;

	}