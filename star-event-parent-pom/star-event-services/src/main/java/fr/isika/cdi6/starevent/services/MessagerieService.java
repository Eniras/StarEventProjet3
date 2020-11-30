package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.MessagerieRepository;
import fr.isika.cdi6.starevent.data.model.messagerie.Messagerie;

@Stateless
public class MessagerieService {
	
	@Inject
	private MessagerieRepository messagerieRepository;

	public void ajouter(Messagerie messagerie) {

		messagerieRepository.create(messagerie);

	}

	public void update(Messagerie messagerie) {
		messagerieRepository.update(messagerie);

	}

	public void retirer(Integer id_messagerie) {
		messagerieRepository.remove(id_messagerie);
	}

	public Messagerie findById(Integer id_messagerie) {
		return (Messagerie) messagerieRepository.findAll();
	}

	public List<Messagerie> findAll() {
		List<Messagerie> list = messagerieRepository.findAll();
		return list;
	}
}
