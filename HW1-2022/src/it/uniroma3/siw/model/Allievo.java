package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	
	public Allievo() {
		super();
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public java.time.LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(java.time.LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private java.time.LocalDate dataNascita;
	
	@Column(nullable = false)
	private String luogoNascita;
	
	@Column(nullable = false, unique = true)
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
