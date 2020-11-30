package fr.isika.cdi6.starevent.data.model.messagerie;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Mail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_mail;

	@NotNull
	private String nomEmetteur;

	@NotNull
	private String descriptionMessage;

	@NotNull
	private Date date_envoi;

	@NotNull
	private String emailEmetteur;

	@NotNull
	private boolean estLu;

	public void affecterTache() {
		//methode qui permettra de transformer un mail en tache???
	}
	public Mail() {
	}

	public Integer getId_mail() {
		return id_mail;
	}

	public void setId_mail(Integer id_mail) {
		this.id_mail = id_mail;
	}

	public String getNomEmetteur() {
		return nomEmetteur;
	}

	public void setNomEmetteur(String nomEmetteur) {
		this.nomEmetteur = nomEmetteur;
	}

	public String getDescriptionMessage() {
		return descriptionMessage;
	}

	public void setDescriptionMessage(String descriptionMessage) {
		this.descriptionMessage = descriptionMessage;
	}

	public Date getDate_envoi() {
		return date_envoi;
	}

	public void setDate_envoi(Date date_envoi) {
		this.date_envoi = date_envoi;
	}

	public String getEmailEmetteur() {
		return emailEmetteur;
	}

	public void setEmailEmetteur(String emailEmetteur) {
		this.emailEmetteur = emailEmetteur;
	}

	public boolean isEstLu() {
		return estLu;
	}

	public void setEstLu(boolean estLu) {
		this.estLu = estLu;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mail [id_mail=");
		builder.append(id_mail);
		builder.append(", nomEmetteur=");
		builder.append(nomEmetteur);
		builder.append(", descriptionMessage=");
		builder.append(descriptionMessage);
		builder.append(", date_envoi=");
		builder.append(date_envoi);
		builder.append(", emailEmetteur=");
		builder.append(emailEmetteur);
		builder.append(", estLu=");
		builder.append(estLu);
		builder.append("]");
		return builder.toString();
	}

}