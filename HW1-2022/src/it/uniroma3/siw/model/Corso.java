package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.Period;
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
	
	
	
	public Corso() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	

	@Column
	private java.time.LocalDate dataInizio;
	
	@Column
	private java.time.Period durata;
	
	@OneToOne
	private Docente docente;
	
	//@OneToMany(mappedBy = "corsi", fetch =  FetchType.EAGER)
	//FETCH: dato che si sta progettando un sistema informativo di un ente, potrebbe essere utile caricare tutti i dati degli allievi di un corso, utilizzando una politica EAGER
	//@JoinColumn(name = "corso_id")
	//private List<Allievo> allievi;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public java.time.LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(java.time.LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public java.time.Period getDurata() {
		return durata;
	}

	public void setDurata(java.time.Period durata) {
		this.durata = durata;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

//	public List<Allievo> getAllievi() {
//		return allievi;
//	}
//
//	public void setAllievi(List<Allievo> allievi) {
//		this.allievi = allievi;
//	}

}
