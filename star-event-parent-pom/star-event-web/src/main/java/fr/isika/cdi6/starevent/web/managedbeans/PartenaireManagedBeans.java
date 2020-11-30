package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cdi6.starevent.dao.repositories.ClientRepository;
import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.gestion.Contrat;
import fr.isika.cdi6.starevent.data.model.gestion.Entreprise;
import fr.isika.cdi6.starevent.data.model.gestion.Evenement;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.utilisateurs.Client;
import fr.isika.cdi6.starevent.data.model.utilisateurs.DashboardClient;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;
import fr.isika.cdi6.starevent.services.ClientService;
import fr.isika.cdi6.starevent.services.PartenaireService;

@Named("partenaireMb")
@RequestScoped
public class PartenaireManagedBeans implements Serializable {

	private static final long serialVersionUID = 1L;

	// TODO : pas de NEW dans JEE et CDI, il faut TOUT injecter
	@Inject
	private PartenaireService partenaireService;
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	
	private List<Partenaire> partenaires = new ArrayList<Partenaire>();
	private Partenaire partenaireEnregistre;
	
	public PartenaireManagedBeans() {
	}
	
	@PostConstruct
	private void init() {
		this.partenaires = partenaireService.findAll();
		this.partenaireEnregistre = new Partenaire();
	}

	public void creer () {
		ProfilUtilisateur profilPartenaire = new ProfilUtilisateur();
		profilPartenaire.setNomUtilisateur("login-2");
		
		Contrat contrat = new Contrat();
		contrat.setText("login-2 - créé manuellement");

		Partenaire partenaire = new Partenaire();
		partenaire.setLogin("login-2");
		partenaire.setPassword("pasw");
		partenaire.setProfilPartenaire(profilPartenaire);
		partenaire.setTypeUtilisateur("partenaire");
		
		partenaire.setEntreprise(new Entreprise());
		
		partenaire.setCataloguePartenaires(new CatalogueOffres());
		contrat.setPartenaire(partenaire);
		partenaire.setContrat(contrat);

		partenaireService.ajouter(partenaire);
		
		partenaireEnregistre = partenaire;
	}
	
	public List<Partenaire> getPartenaires() {
		return partenaires;
	}

	public void setPartenaires(List<Partenaire> partenaires) {
		this.partenaires = partenaires;
	}

	public void ajouter(Partenaire partenaire) {
		partenaireService.ajouter(partenaire);
	}
	
	public void update(Partenaire partenaire) {
		partenaireService.update(partenaire);
	}
	//-------------
	public void save() {
		this.partenaires = partenaireService.findAll();
	}

	public Partenaire getPartenaireEnregistre() {
		return partenaireEnregistre;
	}
	public void setPartenaireEnregistre(Partenaire partenaireEnregistre) {
		this.partenaireEnregistre = partenaireEnregistre;
	}
}
