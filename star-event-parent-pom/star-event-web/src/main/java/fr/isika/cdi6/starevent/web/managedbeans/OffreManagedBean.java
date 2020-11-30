package fr.isika.cdi6.starevent.web.managedbeans;

import java.awt.event.KeyEvent;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

import fr.isika.cdi6.starevent.dao.repositories.UtilisateurRepository;
import fr.isika.cdi6.starevent.data.model.enums.Type;
import fr.isika.cdi6.starevent.data.model.gestion.Contrat;
import fr.isika.cdi6.starevent.data.model.gestion.Entreprise;
import fr.isika.cdi6.starevent.data.model.gestion.Partenaire;
import fr.isika.cdi6.starevent.data.model.offres.CatalogueOffres;
import fr.isika.cdi6.starevent.data.model.offres.Offre;
import fr.isika.cdi6.starevent.data.model.utilisateurs.ProfilUtilisateur;
import fr.isika.cdi6.starevent.services.OffreService;
import fr.isika.cdi6.starevent.services.PartenaireService;

@Named("offreMb")
@SessionScoped
public class OffreManagedBean implements Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private OffreService offreService;

	@Inject
	private PartenaireService partenaireService;

	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	private List<Offre> offres;
	
	private static Offre offreSelectionnee;

	public OffreManagedBean() {
	}

	@PostConstruct
	private void init() {
		offres = offreService.findAll();
	}

	public static String detailOffre(Offre offre) {
		offreSelectionnee = offre;
		return "offre.xhtml?faces-redirect=true\"";
	}
	
	public static String detailOffreSelectByClient(Offre offre) {
		offreSelectionnee = offre;
		return "offreAjoutEvent.xhtml?faces-redirect=true\"";
	}
	
	public void updateDescription(ValueChangeEvent e) {
		if ((e.getNewValue() != null) && (e.getNewValue() != "") && (e.getOldValue() != null)
				&& (e.getOldValue() != "")&&(e.getNewValue() != "Modify your description") && (e.getOldValue() != "Modify your description")) {
			String description = e.getNewValue().toString();
			offreSelectionnee.setDescriptionOffre(description);
			offreService.update(offreSelectionnee);
		}
		}

		
	

	public void updateInformation(ValueChangeEvent e) {

			offreSelectionnee.setInfoComplementaire(e.getNewValue().toString());
			offreService.update(offreSelectionnee);
		
	}
	
	public void offreSalle() {
		offres=offreService.findAll();
		offres = this.offres.stream().filter(o->o.getPartenaire().getEntreprise().getDomaineActivite().equals(Type.SALLE)).collect(Collectors.toList());
	}
	
	public void offreRestaurant() {
		offres=offreService.findAll();
		offres = this.offres.stream().filter(o->o.getPartenaire().getEntreprise().getDomaineActivite().equals(Type.RESTAURATION)).collect(Collectors.toList());
	}
	
	public void offreTraiteur() {
		offres=offreService.findAll();
		offres = this.offres.stream().filter(o->o.getPartenaire().getEntreprise().getDomaineActivite().equals(Type.TRAITEUR)).collect(Collectors.toList());
	}
	
	public void offreAll() {
		offres=offreService.findAll();
		
	}
	
	public void update(Offre offre) {
		offreService.update(offre);
	}
	
	public List<Offre> getOffres() {
		return offres;
	}

	public void setOffres(List<Offre> offres) {
		this.offres = offres;
	}

	public OffreService getOffreService() {
		return offreService;
	}

	public void setOffreService(OffreService offreService) {
		this.offreService = offreService;
	}

	public PartenaireService getPartenaireService() {
		return partenaireService;
	}

	public void setPartenaireService(PartenaireService partenaireService) {
		this.partenaireService = partenaireService;
	}

	public UtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public Offre getOffreSelectionnee() {
		return offreSelectionnee;
	}

	public void setOffreSelectionnee(Offre offreSelectionnee) {
		this.offreSelectionnee = offreSelectionnee;
	}
	
	
	public void creerOffre() {
		ProfilUtilisateur profilPartenaire = new ProfilUtilisateur();
		profilPartenaire.setNomUtilisateur("Albert");

		Contrat contrat = new Contrat();
		contrat.setText("Contrat Albert");

		Partenaire partenaire = new Partenaire();
		partenaire.setLogin("albert");
		partenaire.setPassword("pasw");
		partenaire.setProfilPartenaire(profilPartenaire);
		partenaire.setTypeUtilisateur("partenaire");

		partenaire.setEntreprise(new Entreprise());

		contrat.setPartenaire(partenaire);
		partenaire.setContrat(contrat);

		
		Offre offre = new Offre();
		offre.setPartenaire(partenaire);
		offre.setNomOffre("offre albert");
		offre.setImageOffre("https://img.freepik.com/vecteurs-libre/journee-internationale-du-design-plat-yoga_52683-38335.jpg?size=338&ext=jpg&ga=GA1.2.1158341606.1602679821");
		
		Offre offre2 = new Offre();
		offre2.setPartenaire(partenaire);
		offre2.setNomOffre("offre 2 albert");
		offre2.setImageOffre("https://img.freepik.com/vecteurs-libre/design-plat-style-vie-esprit-corps-yoga_52683-38392.jpg?size=338&ext=jpg&ga=GA1.2.1158341606.1602679821");
		
		CatalogueOffres catalogue = new CatalogueOffres();
		catalogue.ajouter(offre);
		catalogue.ajouter(offre2);
		partenaire.setCataloguePartenaires(catalogue);
		
	//	offreService.ajouter(offre, partenaire.getIdUtilisateur());
		
		offres=partenaire.getCataloguePartenaires().getOffres();
		
		partenaireService.ajouter(partenaire);
		


	}
	

}
