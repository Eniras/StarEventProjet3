package fr.isika.cdi6.starevent.web.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cdi6.starevent.data.model.gestion.Contrat;
import fr.isika.cdi6.starevent.data.model.gestion.Entreprise;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;
import fr.isika.cdi6.starevent.services.ContratService;
import fr.isika.cdi6.starevent.services.PartenaireService;

@Named("contratMb")
@RequestScoped
public class ContratManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ContratService contratService;

	@Inject
	private PartenaireService partenaireService;

	private List<Contrat> contrats = new ArrayList<Contrat>();
	private Contrat contratEnregistre;

	@PostConstruct
	private void init() {
		this.contrats = contratService.findAll();
		this.contratEnregistre = new Contrat();
	}

	public void creerContrat(Integer id) {
		
		Contrat contrat = new Contrat();
		contrat.setFilePath("new file path");
		contrat.setText("Je suis votre nouveau partenaire");

		contratService.ajouter(contrat, id);
		
		contratEnregistre=contrat;
	}

	public ContratService getContratService() {
		return contratService;
	}

	public void setContratService(ContratService contratService) {
		this.contratService = contratService;
	}

	public PartenaireService getPartenaireService() {
		return partenaireService;
	}

	public void setPartenaireService(PartenaireService partenaireService) {
		this.partenaireService = partenaireService;
	}

	public List<Contrat> getContrats() {
		return contrats;
	}

	public void setContrats(List<Contrat> contrats) {
		this.contrats = contrats;
	}

	public Contrat getContratEnregistre() {
		return contratEnregistre;
	}

	public void setContratEnregistre(Contrat contratEnregistre) {
		this.contratEnregistre = contratEnregistre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
