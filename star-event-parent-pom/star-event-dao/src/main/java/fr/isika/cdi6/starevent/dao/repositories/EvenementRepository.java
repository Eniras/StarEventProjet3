package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import fr.isika.cdi6.starevent.data.model.gestion.Evenement;

@Stateless
public class EvenementRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public EvenementRepository() {
	}

	public List<Evenement> findAll() {
		return entityManager.createNamedQuery("Evenement.findAll", Evenement.class).getResultList();
	}
	
	public List<Evenement> findByIdDash(Integer idDashboard) {
		return entityManager.createNamedQuery("Evenement.findByIdDash", Evenement.class)
				.setParameter("idDashboard", idDashboard).getResultList();
	}

	public void create(Evenement evenement) {
		this.entityManager.persist(evenement);
	}

	public void update(Evenement evenement) {
		this.entityManager.merge(evenement);
	}

	public void remove(Integer idEvenement) {
		Evenement evenement = this.entityManager.find(Evenement.class, idEvenement);
		this.entityManager.remove(evenement);
	}

	public Evenement findById(Integer IdEvenement) {
		return entityManager.find(Evenement.class, IdEvenement);
	}

	
}
