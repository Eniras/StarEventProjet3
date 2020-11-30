package fr.isika.cdi6.starevent.dao.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cdi6.starevent.data.model.messagerie.Mail;

public class MailRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public MailRepository() {

	}

	public List<Mail> findAll() {
		return entityManager.createNamedQuery("Mail.findAll", Mail.class).getResultList();
	}

	public void create(Mail mail) {
		this.entityManager.persist(mail);
		this.entityManager.flush();

	}

	public void update(Mail mail) {
		entityManager.merge(mail);
		this.entityManager.flush();

	}

	public void remove(Integer id_mail) {
		Mail mail = entityManager.find(Mail.class, id_mail);
		entityManager.remove(mail);
		this.entityManager.flush();
	}

	public Mail findById(Integer id_mail) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Mail.class, id_mail);
	}
}
