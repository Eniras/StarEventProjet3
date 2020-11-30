package fr.isika.cdi6.starevent.data.model.offres;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;

@Entity
@NamedQueries({
	@NamedQuery(name = "Offre.findAll", query = "Select o from Offre o")
})
public class Offre {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOffre;

	private String nomOffre;

	private String descriptionOffre;

	private String infoComplementaire;

	public String getInfoComplementaire() {
		return infoComplementaire;
	}

	public void setInfoComplementaire(String infoComplementaire) {
		this.infoComplementaire = infoComplementaire;
	}

	private int capaciteMax;
	

	private String imageOffre;


	private BigDecimal prixOffre;

	@ManyToOne
	private Partenaire partenaire;
	
	public BigDecimal getPrixOffre() {
		return prixOffre;
	}
	
	public void setPrixOffre(BigDecimal prixOffre) {
		this.prixOffre = prixOffre;
	}
	public Offre() {
	}

	public Integer getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Integer idOffre) {
		this.idOffre = idOffre;
	}

	public String getNomOffre() {
		return nomOffre;
	}

	public void setNomOffre(String nomOffre) {
		this.nomOffre = nomOffre;
	}

	public String getDescriptionOffre() {
		return descriptionOffre;
	}

	public void setDescriptionOffre(String descriptionOffre) {
		this.descriptionOffre = descriptionOffre;
	}

	public int getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}

	public String getImageOffre() {
		return imageOffre;
	}

	public void setImageOffre(String imageOffre) {
		this.imageOffre = imageOffre;
	}

	public Partenaire getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}

}