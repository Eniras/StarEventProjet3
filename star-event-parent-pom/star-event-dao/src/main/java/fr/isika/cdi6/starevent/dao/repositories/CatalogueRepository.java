package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;

@Stateless
public class CatalogueRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public CatalogueRepository() {
	}

	public List<CatalogueOffres> findAll() {
		return entityManager.createNamedQuery("CatalogueOffres.findAll", CatalogueOffres.class).getResultList();
	}

	public void create(CatalogueOffres catalogueOffre) {
		this.entityManager.persist(catalogueOffre);
	}

	public void update(CatalogueOffres catalogueOffre) {
		this.entityManager.merge(catalogueOffre);
	}

	public void remove(Integer idCatalogue) {
		CatalogueOffres catalogue = this.entityManager.find(CatalogueOffres.class, idCatalogue);
		this.entityManager.remove(catalogue);
	}

//	public void remove (Offre offre) {
//		List<CatalogueOffres> catalogue = this.findAll();
//		
//	}
	public CatalogueOffres findById(Integer idCatalogue) {
		return entityManager.find(CatalogueOffres.class, idCatalogue);
	}
}
