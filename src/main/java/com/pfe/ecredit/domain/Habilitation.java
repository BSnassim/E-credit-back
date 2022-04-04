package com.pfe.ecredit.domain;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Habilitation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "SEQ_HAB", allocationSize = 1)
	private Integer id;
	private String libelle;
}
