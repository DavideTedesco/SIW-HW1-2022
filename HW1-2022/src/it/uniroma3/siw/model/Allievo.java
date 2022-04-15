package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private java.time.LocalDate dataNascita;
	
	@Column(nullable = false)
	private String luogoNascita;
	
	@Column(nullable = false)
	private String matricola;
	
	@Column(nullable = false)
	private String email;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//FETCH: non interessa caricare tutte le informazioni di una societa controllando un Allievo
	//CASCADE: bisogna aggiornare la lista di allievi di ogni corso quando si modificano le informazioni dell'allievo, inoltre societa e allievo consistono in una composizione
	private Societa societa;
	
	@OneToMany
	//@JoinColumn(name = "allievo_id")
	private List<Corso> corsi;
}
