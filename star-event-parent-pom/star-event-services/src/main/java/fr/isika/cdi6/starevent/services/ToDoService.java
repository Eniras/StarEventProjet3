package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.ToDoRepository;
import fr.isika.cdi6.starevent.data.model.taches.Tache;
import fr.isika.cdi6.starevent.data.model.taches.ToDo;

@Stateless
public class ToDoService {

	@Inject
	private ToDoRepository toDoRepository;

	public ToDo findById(Integer idToDo) {
		return toDoRepository.findById(idToDo);
	}

	public List<ToDo> findAll() {
		return toDoRepository.findAll();
	}

	public ToDo findSingleToDo() {
		return toDoRepository.findSingleToDo();
	}
	public void update(ToDo toDo) {
		toDoRepository.update(toDo);

	}
	public List<Tache> findTacheByIdToDo(Integer idToDo) {
		return  toDoRepository.findTacheByIdToDo(idToDo);
	}
}
