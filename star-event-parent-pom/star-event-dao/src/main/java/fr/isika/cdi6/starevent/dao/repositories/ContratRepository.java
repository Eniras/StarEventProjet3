package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Contrat;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;

@Stateless
public class ContratRepository {

		// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
	@PersistenceContext
	private EntityManager entityManager;

	public ContratRepository() {
	}

	public void create(Contrat contrat, Integer idPartenaire) {
		this.entityManager.persist(contrat);
		
		Partenaire partenaire = this.entityManager.find(Partenaire.class, idPartenaire);
		
		contrat.setPartenaire(partenaire);
		
		partenaire.setContrat(contrat);
		
		this.entityManager.merge(contrat);
		this.entityManager.merge(partenaire);
	
		this.entityManager.flush();
	
	}

	public void update(Contrat contrat) {
		entityManager.merge(contrat);
	}

	public void remove(Integer idContrat) {
		Contrat contrat = entityManager.find(Contrat.class, idContrat);
		entityManager.remove(contrat);
	}

	public Contrat findById(Integer idContrat) {
		return (Contrat) entityManager.find(Contrat.class, idContrat);
	}
	
	public Contrat findByIdPartenaire(Integer idPartenaire) {
		return (Contrat) entityManager.createNamedQuery("Contrat.findByIdPartenaire", Contrat.class)
				.setParameter("idPartenaire", idPartenaire).getSingleResult();
	}
	public List<Contrat> findAll(){
		return entityManager.createNamedQuery("Contrat.findAll", Contrat.class).getResultList();
	}
}
