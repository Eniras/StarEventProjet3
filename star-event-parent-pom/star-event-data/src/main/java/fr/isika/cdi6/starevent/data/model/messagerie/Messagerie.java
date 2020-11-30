package fr.isika.cdi6.starevent.data.model.messagerie;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Messagerie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_messagerie;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//	@Fetch(value = FetchMode.SUBSELECT)
	private List<Mail> mails;

	public Messagerie() {
	}

	public void ajouterMail(Mail mail) {
		this.getMails().add(mail);
	}

	public void retirerMail(Mail mail) {
		this.getMails().remove(mail);
	}

	public Integer getId_messagerie() {
		return id_messagerie;
	}

	public void setId_messagerie(Integer id_messagerie) {
		this.id_messagerie = id_messagerie;
	}

	public List<Mail> getMails() {
		return mails;
	}

	public void setMails(List<Mail> mails) {
		this.mails = mails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Messagerie [id_messagerie=");
		builder.append(id_messagerie);
		builder.append("]");
		return builder.toString();
	}

}