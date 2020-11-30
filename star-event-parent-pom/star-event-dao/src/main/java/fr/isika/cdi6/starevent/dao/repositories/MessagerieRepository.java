package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.messagerie.Messagerie;

public class MessagerieRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public MessagerieRepository() {

	}

	public List<Messagerie> findAll() {
		return entityManager.createNamedQuery("Messagerie.findAll", Messagerie.class).getResultList();
	}

	public void create(Messagerie messagerie) {
		this.entityManager.persist(messagerie);

//			List<Mail> mail = (List<Mail>) this.entityManager.find(Mail.class, id_mail);
//			
//			messagerie.setMails(mail);	
//			
//			this.entityManager.merge(messagerie);
//			this.entityManager.merge(mail);

		this.entityManager.flush();

	}

	public void update(Messagerie messagerie) {
		entityManager.merge(messagerie);
	}

	public void remove(Integer id_messagerie) {
		entityManager.find(Messagerie.class, id_messagerie);
		this.entityManager.flush();

	}

}
