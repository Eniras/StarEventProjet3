package fr.isika.cdi6.starevent.data.model.utilisateurs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "ProfilUtilisateur.findAll", query = "select p from ProfilUtilisateur p") })

public class ProfilUtilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idProfil;
	
	private String nomUtilisateur;
	
	private String prenomUtilisateur;
	
	private String emailUtilisateur;
	
	private String telephoneUtilisateur;
	
	private String descriptionUtilisateur;
	
	private String photoProfilUtilisateur;

	public Integer getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(Integer idProfil) {
		this.idProfil = idProfil;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getTelephoneUtilisateur() {
		return telephoneUtilisateur;
	}

	public void setTelephoneUtilisateur(String telephoneUtilisateur) {
		this.telephoneUtilisateur = telephoneUtilisateur;
	}

	public String getDescriptionUtilisateur() {
		return descriptionUtilisateur;
	}

	public void setDescriptionUtilisateur(String descriptionUtilisateur) {
		this.descriptionUtilisateur = descriptionUtilisateur;
	}

	public String getPhotoProfilUtilisateur() {
		return photoProfilUtilisateur;
	}

	public void setPhotoProfilUtilisateur(String photoProfilUtilisateur) {
		this.photoProfilUtilisateur = photoProfilUtilisateur;
	}
}