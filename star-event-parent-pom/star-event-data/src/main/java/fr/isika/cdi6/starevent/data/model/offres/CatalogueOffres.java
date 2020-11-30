package fr.isika.cdi6.starevent.data.model.offres;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "CatalogueOffres.findAll", query = "select c from CatalogueOffres c") })

public class CatalogueOffres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCatalogue;
	
	private String titre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Offre> offres;
	
	private LocalDate dateValidite;
	
	public CatalogueOffres() {
	offres=new ArrayList<>();
	}

	
	
	
	public void ajouter(Offre offre) {
		this.getOffres().add(offre);
	}

	public void retirer(Offre offre) {
		this.getOffres().remove(offre);
	}

	public Integer getId_Catalogue() {
		return idCatalogue;
	}

	public void setId_Catalogue(Integer id_Catalogue) {
		this.idCatalogue = id_Catalogue;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public LocalDate getDateValidite() {
		return dateValidite;
	}

	public void setDateValidite(LocalDate dateValidite) {
		this.dateValidite = dateValidite;
	}
}