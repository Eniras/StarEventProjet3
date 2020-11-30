package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class PartenaireRepository {

	// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
	@PersistenceContext
	private EntityManager entityManager;

	public PartenaireRepository() {
	}

	public List<Partenaire> findAll(){
		return entityManager.createNamedQuery("Partenaire.findAll", Partenaire.class).getResultList();
	}

	public void create(Partenaire partenaire) {
		this.entityManager.persist(partenaire.getContrat());

		List<Offre> offres = partenaire.getCataloguePartenaires().getOffres();
		offres.stream().forEach(o->this.entityManager.persist(o));	
		
		this.entityManager.persist(partenaire.getCataloguePartenaires());
		
		this.entityManager.persist(partenaire);
	}

	public void update(Partenaire partenaire) {
		entityManager.merge(partenaire);
	}

	public void remove(Integer idPartenaire) {
		Partenaire partenaire = entityManager.find(Partenaire.class, idPartenaire);
		entityManager.remove(partenaire);
	}

	public Partenaire findById(Integer idPartenaire) {
		return (Partenaire) entityManager.find(Partenaire.class, idPartenaire);
	}
	
}
