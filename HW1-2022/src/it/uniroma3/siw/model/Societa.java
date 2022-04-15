package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Societa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String ragioneSociale;
	
	@Column(nullable = false)
	private String telefono;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//CASCADE: e' necessario avere il cascade poiche' ogni societa' necessita di cambiare un indirizzo se necessario
	private Indirizzo indirizzoSede;
}
