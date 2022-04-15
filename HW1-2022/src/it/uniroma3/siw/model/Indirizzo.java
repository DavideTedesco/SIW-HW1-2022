package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Indirizzo {

	@Column(nullable = false)
	private String via;
	
	@Column(nullable = false)
	private String numeroCivico;
	
	@Column(nullable = false)
	private String comune;
	
	@Column(nullable = false)
	private String cap;
	
	@Column(nullable = false)
	private String provincia;
}
