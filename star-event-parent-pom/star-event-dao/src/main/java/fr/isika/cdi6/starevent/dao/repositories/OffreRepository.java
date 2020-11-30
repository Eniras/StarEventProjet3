package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class OffreRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public OffreRepository() {
	}

	public List<Offre> findAll() {
		return entityManager.createNamedQuery("Offre.findAll", Offre.class).getResultList();
	}

	public void create(Offre offre) {
		this.entityManager.persist(offre);
	}

	public void update(Offre offre) {
		this.entityManager.merge(offre);
	}

	public void remove(Integer idOffre) {
		Offre offre = this.entityManager.find(Offre.class, idOffre);
		this.entityManager.remove(offre);
	}

	public Offre findById(Integer idOffre) {
		return entityManager.find(Offre.class, idOffre);
	}
}
