package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.gestion.Reservation;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.data.model.taches.Tache;
import fr.isika.cdi6.starevent.data.model.taches.ToDo;

public class TacheRepository {
	
	@PersistenceContext
	private static EntityManager entityManager;

	public TacheRepository() {

	}

	public static List<Tache> findAll() {
		return entityManager.createNamedQuery("Tache.findAll", Tache.class).getResultList();
	}
	
	public void create(Tache tache, Integer idToDo) {
		this.entityManager.persist(tache);
		ToDo toDo = (ToDo) this.entityManager.find(ToDo.class, idToDo);
		toDo.ajouter(tache);
		entityManager.merge(toDo);

	}

	public void update(Tache tache) {
		entityManager.merge(tache);
		this.entityManager.flush();

	}

	public void remove(Integer id_tache) {
		Tache tache = entityManager.find(Tache.class, id_tache);
		entityManager.remove(tache);
		this.entityManager.flush();
	}

	public static Tache findById(Integer id_tache) {
		return entityManager.find(Tache.class, id_tache);
	}

}
