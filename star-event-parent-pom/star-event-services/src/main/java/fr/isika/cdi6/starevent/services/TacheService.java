package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.TacheRepository;
import fr.isika.cdi6.starevent.data.model.taches.Tache;

@Stateless
public class TacheService {

	@Inject
	private TacheRepository tacheRepository;

	public void ajouter(Tache tache, Integer idToDo) {
	
		tacheRepository.create(tache, idToDo);

	}

	public void update(Tache tache) {
		tacheRepository.update(tache);

	}

	public void retirer(Integer id_tache) {
		tacheRepository.remove(id_tache);
	}

	public Tache findById(Integer id_tache) {
		return (Tache) tacheRepository.findAll();
	}

	public List<Tache> findAll() {
		List<Tache> list = tacheRepository.findAll();
		return list;
	}

}
