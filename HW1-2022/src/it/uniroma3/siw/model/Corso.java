package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Corso {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private java.time.LocalDate dataInizio;
	
	@Column(nullable = false)
	private java.time.Period durata;
	
	@OneToOne
	private Docente docente;
	
	@OneToMany(mappedBy = "corsi", fetch =  FetchType.EAGER)
	//FETCH: dato che si sta progettando un sistema informativo di un ente, potrebbe essere utile caricare tutti i dati degli allievi di un corso, utilizzando una politica EAGER
	//@JoinColumn(name = "corso_id")
	private List<Allievo> allievi;
}
