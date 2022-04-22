package it.uniroma3.siw.model;

import javax.persistence.*;

@Entity
public class Societa {


	public Societa() {
	}

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
	
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Indirizzo getIndirizzoSede() {
		return indirizzoSede;
	}

	public void setIndirizzoSede(Indirizzo indirizzoSede) {
		this.indirizzoSede = indirizzoSede;
	}

}
