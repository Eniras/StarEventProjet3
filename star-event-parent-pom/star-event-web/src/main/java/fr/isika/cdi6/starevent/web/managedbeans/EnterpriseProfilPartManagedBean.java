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

@Named("enterpriseProfilPartMb")
@RequestScoped
public class EnterpriseProfilPartManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private static LoginManagedBean loginMb;
	
	@Inject
	PartenaireService partenaireService;
	
	
	private Partenaire partenaire;
	
	//private Entreprise company;
	
	@PostConstruct
	
	public void init() {
		partenaire = partenaireService.findById(loginMb.getId());
	}

	
	public Partenaire getPartenaire() {
		return partenaire;
	}


	public void setPartenaire(Partenaire partenaire) {
		this.partenaire = partenaire;
	}


	
	
	
}
