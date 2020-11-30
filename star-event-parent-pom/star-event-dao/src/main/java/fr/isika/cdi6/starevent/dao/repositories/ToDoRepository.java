package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.admin.Admin;
import fr.isika.cdi6.starevent.data.model.taches.Tache;
import fr.isika.cdi6.starevent.data.model.taches.ToDo;

@Stateless
public class ToDoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public ToDoRepository() {

	}

	public void create(ToDo toDo, Integer idAdmin) {
		this.entityManager.persist(toDo);
		Admin admin = this.entityManager.find(Admin.class, idAdmin);
		admin.setToDo(toDo);
		this.entityManager.merge(toDo);
		this.entityManager.merge(admin);
		this.entityManager.flush();
	}

	public void update(ToDo toDo) {
		entityManager.merge(toDo);
	}

	public void remove(Integer idToDo) {
		ToDo toDo = entityManager.find(ToDo.class, idToDo);
		entityManager.remove(toDo);
	}

	public ToDo findById(Integer idToDo) {
		return (ToDo) entityManager.find(ToDo.class, idToDo);
	}
	
	public List<ToDo> findAll() {
		return entityManager.createNamedQuery("ToDo.findAll", ToDo.class).getResultList();
	}
	public ToDo findSingleToDo() {
		return entityManager.createNamedQuery("ToDo.findAll", ToDo.class).getSingleResult();
	}
	public List<Tache> findTacheByIdToDo(Integer idToDo) {
		return  entityManager.createNamedQuery("ToDo.findTacheByIdToDo",Tache.class).setParameter("idToDo", idToDo)
				.getResultList();
	}
	
}
