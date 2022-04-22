package it.uniroma3.siw.main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;
import it.uniroma3.siw.model.Societa;

public class EnteMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ente-unit");
		EntityManager em = emf.createEntityManager();
		Societa societa = new Societa();
		societa.setIndirizzoSede(null);
		societa.setRagioneSociale("Pippo SRL");
		societa.setTelefono("+3906060606");
		
		Docente docente = new Docente();
		docente.setNome("Paolo");
		docente.setCognome("Merialdo");
		docente.setPartitaIva("123");
		docente.setDataNascita(LocalDate.of(1965, 07, 27));
		docente.setLuogoNascita("Genova");
		
		Corso corso1 = new Corso();
		Corso corso2 = new Corso();
		
		corso1.setNome("A");
		corso2.setNome("B");
		
		docente.getCorsi().add(corso1);
		docente.getCorsi().add(corso2);
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(docente);
		tx.commit();
		
		//em.close();
		//chiudiamo l'entity manager perchè l'entita' docente che era managed ed i dati li aveva gia' e avrebbe potuto non fare l'interrogazione
		//em = emf.createEntityManager();
		
		em.clear(); //alternativo a chiusura e riapertura

		TypedQuery<Docente> query = em.createQuery("SELECT d FROM Docente d", Docente.class);
		List<Docente> docenti = query.getResultList();
		System.out.println("----");
		//per vedere la strategia lazy load usando i dati con interrogazione
		for(Docente d : docenti) {
			for(Corso c : d.getCorsi()) {
				System.out.println(c.getNome());
			}
		}
		emf.close();
	}
}
