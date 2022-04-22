package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Indirizzo {
	
	public Indirizzo() {
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
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
	
	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
