package fr.isika.cdi6.starevent.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cdi6.starevent.dao.repositories.MailRepository;
import fr.isika.cdi6.starevent.data.model.messagerie.Mail;

@Stateless
public class MailService {
	
	@Inject
	private MailRepository mailRepository;

	public void ajouter(Mail mail) {

		mailRepository.create(mail);

	}

	public void update(Mail mail) {
		mailRepository.update(mail);

	}

	public void retirer(Integer id_mail) {
		mailRepository.remove(id_mail);
	}

	public Mail findById(Integer id_mail) {
		return mailRepository.findById(id_mail);
	}

	public List<Mail> findAll() {
		return mailRepository.findAll();
		
	}
}
