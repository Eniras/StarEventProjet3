package fr.isika.cdi6.starevent.data.model.gestion;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Utilisateur;

@Entity
@DiscriminatorValue(value = "Partenaire")
@NamedQueries({ 
	@NamedQuery(name = "Partenaire.findAll", query = "select p from Partenaire p"),
		@NamedQuery(name = "Partenaire.findByLogin", query = "select u from Utilisateur u where u.login=:loginUtilisateur")

})
public class Partenaire extends Utilisateur implements Serializable {


	private static final long serialVersionUID = -3000142332003340853L;

	//@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	private ProfilUtilisateur profilPartenaire;

//bidir
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private Contrat contrat;

	@OneToOne(cascade = CascadeType.ALL) // unidir
	private Entreprise entreprise;

	@OneToOne(cascade = CascadeType.ALL) // unidir
	private CatalogueOffres cataloguePartenaires;

	public Partenaire() {
	}

	public void ajouter(Offre offre) {
		this.getCataloguePartenaires().ajouter(offre);
	}

	public void retirer(Offre offre) {
		this.getCataloguePartenaires().retirer(offre);
	}

	public ProfilUtilisateur getProfilPartenaire() {
		return profilPartenaire;
	}

	public void setProfilPartenaire(ProfilUtilisateur profilPartenaire) {
		this.profilPartenaire = profilPartenaire;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public CatalogueOffres getCataloguePartenaires() {
		return cataloguePartenaires;
	}

	public void setCataloguePartenaires(CatalogueOffres cataloguePartenaires) {
		this.cataloguePartenaires = cataloguePartenaires;
	}

}